package cn.learnssm.dao;

import cn.learnssm.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class IAccountDaoTest {

    private SqlSession session;
    private SqlSessionFactory factory;
    private InputStream inputStream;

    @Before
    public void init() throws Exception {
        //加载配置文件
        inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建工厂
        factory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建sqlSession对象
        session = factory.openSession();

    }

    @After
    public void destory() throws Exception {
        //释放资源
        session.close();
        inputStream.close();
    }

    @Test
    public void findAllTest() throws Exception {
        //获取代理对象
        IAccountDao accountDao = session.getMapper(IAccountDao.class);

        List<Account> list = accountDao.findAll();
        for (Account account : list) {
            System.out.println(account);
        }

    }

    @Test
    public void saveTest() throws Exception {
        //获取代理对象
        IAccountDao accountDao = session.getMapper(IAccountDao.class);

        Account account = new Account();
        account.setName("啊");
        account.setMoney(900);
        //System.out.println(account);
        accountDao.save(account);
        // 提交事务
        session.commit();


    }
}
