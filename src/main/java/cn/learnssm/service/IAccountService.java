package cn.learnssm.service;

import cn.learnssm.domain.Account;

import java.util.List;

public interface IAccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAll();

    /**
     * 保存
     * @param account
     */
    void save(Account account);
}
