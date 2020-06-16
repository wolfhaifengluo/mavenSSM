package cn.learnssm.controller;

import cn.learnssm.domain.User;
import cn.learnssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
//将java对象转为json格式的数据
@ResponseBody
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/findAll")
    public List<User> findAll()
    {
        List<User> list = userService.findAll();
        return list;
    }
    @RequestMapping("/findById")
    public User findById(Integer id)
    {
        return userService.findById(id);
    }

    @RequestMapping("/insert")
    public void insert(@RequestBody User user)
    {
        userService.insert(user);
    }

    @RequestMapping("/update")
    public void update(@RequestBody User user)
    {
        userService.update(user);
    }
}
