package cn.learnssm.service.impl;

import cn.learnssm.dao.IAccountDao;
import cn.learnssm.domain.Account;
import cn.learnssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("iAccountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDao iAccountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("查询所有账户...");
        List<Account> list = iAccountDao.findAll();
        for (Account account:list) {
            System.out.println(account);
        }
        return list;
    }

    @Override
    public void save(Account account) {
        System.out.println("保存账户...");
        iAccountDao.save(account);
    }
}
