package com.springsecurity.springsecurity2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName SController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/14 14:09
 * @Version 1.0
 */
@Controller
public class SController {

    @GetMapping("/mylogin")
    public String mylogin(){
        return "/mylogin.html";
    }
    /**
     * 登陆成功重定向到此
     * @return
     */
    @GetMapping("/index")
    public String hello3(){
        return "/index.html";
    }

    @GetMapping("/sysuser")
    @ResponseBody
    public String user(){
        return "user";
    }

    @GetMapping("/syslog")
    @ResponseBody
    public String log(){
        return "log";
    }

    @GetMapping("/biz1")
    @ResponseBody
    public String service1(){
        return "service1";
    }

    @GetMapping("/biz2")
    @ResponseBody
    public String service2(){
        return "service2";
    }
}
