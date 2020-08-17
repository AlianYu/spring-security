package com.springsecurity.springsecurity2.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springsecurity.springsecurity2.Service.UserService;
import com.springsecurity.springsecurity2.bean.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/hello/test1")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/test2")
    public String hello2(){
        return "hello2";
    }


    @GetMapping("/http/index")
    public String hello4(String username){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        List<User> list = userService.getUserByUserName(queryWrapper);
        for (User user : list){
            System.out.println(user);
        }

        return "你";
    }



    /**
     * 登录的提交接口
     * @param username
     * @return
     */
    /*@PostMapping("/validate/mylogin")
    public String mylogin(String username){
        System.out.println("登录用户="+username);
        return "你登录成功？";
    }*/

}
