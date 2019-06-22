package com.itheima.controller;

import com.itheima.domain.TbUser;
import com.itheima.model.Result;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by tanshuai on 2019/6/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/login")
    public Result login(TbUser user, HttpSession session){
        try {
            boolean login = userService.login(user);
            if(login){
                //如果登陆成功 将用户信息存储到session中
                session.setAttribute("user",user);
            }
            return new Result(true,"登陆成功");
        }catch (Exception e){
            e.printStackTrace();
            return  new Result(false,e.getMessage());
        }
    }
}
