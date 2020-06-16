package cn.learnssm.service;

import cn.learnssm.domain.User;

import java.util.List;

public interface IUserService {

    public List<User> findAll();

    public User findById(Integer id);

    public void insert(User user);

    public void update(User user);

}
