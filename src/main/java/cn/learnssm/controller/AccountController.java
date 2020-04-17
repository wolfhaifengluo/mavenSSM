package cn.learnssm.controller;

import cn.learnssm.domain.Account;
import cn.learnssm.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private IAccountService as;

    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("AccountController执行了...");
        List<Account> list = as.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/save")
    public void findAll(Account account, HttpServletResponse response, HttpServletRequest request) throws IOException {
        System.out.println("AccountController执行了...");
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        as.save(account);
        return;
    }

}
