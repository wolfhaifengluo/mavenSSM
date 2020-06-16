package cn.learnssm.service.impl;

import cn.learnssm.dao.IUserDao;
import cn.learnssm.domain.User;
import cn.learnssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUserServiceimpl implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public List<User> findAll() {
        List<User> list = iUserDao.findAll();
        return list;
    }

    @Override
    public User findById(Integer id) {
        return iUserDao.findById(id);
    }

    @Override
    public void insert(User user) {
        iUserDao.insert(user);
    }

    @Override
    public void update(User user) {
        iUserDao.update(user);
    }
}
