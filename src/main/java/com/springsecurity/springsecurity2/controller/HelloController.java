package com.springsecurity.springsecurity2.controller;

import com.springsecurity.springsecurity2.bean.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @GetMapping("/hello/test1")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/test2")
    public String hello2(){
        return "hello2";
    }


    @GetMapping("/http/index")
    public String hello4(){
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
