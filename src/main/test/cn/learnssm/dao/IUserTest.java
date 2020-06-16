package cn.learnssm.dao;

import cn.learnssm.domain.User;
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

import java.io.InputStream;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class IUserTest {

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
    public void insertTest() throws Exception {
        //获取代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);
        User user = new User();
        user.setUsername("haifeng");
        user.setPassword("123");
        user.setSex("nan");
        user.setAge(18);
        user.setEmail("99548");
        userDao.insert(user);
        // 提交事务
        session.commit();


    }

    @Test
    public void findAllTest() throws Exception {
        //获取代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        List<User> list = userDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }

    }

    @Test
    public void findByIdTest() throws Exception {
        //获取代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        User user = userDao.findById(1);
        System.out.println(user);

    }

    @Test
    public void updateTest() throws Exception {
        //获取代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        User user = new User();
        user.setId(1);
        user.setUsername("haifeng");
        user.setPassword("556");
        userDao.update(user);
        // 提交事务
        session.commit();
    }
}
