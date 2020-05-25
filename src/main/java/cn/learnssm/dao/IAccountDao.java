package cn.learnssm.dao;

import cn.learnssm.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountDao {

    /**
     * 查询所有
     * @return
     */
    //@Select("select * from account")
    List<Account> findAll();

    /**
     * 保存
     * @param account
     */
    @Insert("insert into account(name,money) values (#{name},#{money})")
    void save(Account account);
}
