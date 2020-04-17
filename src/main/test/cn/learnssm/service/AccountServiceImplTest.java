package cn.learnssm.service;

import cn.learnssm.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class AccountServiceImplTest {

    @Autowired
    private IAccountService as;

    @Test
    public void findAll(){
        as.findAll();
    }
    @Test
    public void save(){
        Account account = new Account();
        account.setName("哈哈");
        account.setMoney(1818d);
        as.save(account);
    }

}
