package cn.learnssm.dao;

import cn.learnssm.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user where id=#{id}")
    public User findById(Integer id);

    @Insert("insert into user(username,password,sex,age,email) values(#{username},#{password},#{sex},#{age},#{email})")
    public void insert(User user);

    @Update("update user set username=#{username},password=#{password},sex=#{sex},age=#{age},email=#{email} where id=#{id}")
    public void update(User user);
}
