package com.springsecurity.springsecurity2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @ClassName SController
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/14 14:09
 * @Version 1.0
 */
@Controller
public class SController {
    /**
     * 登陆成功重定向到此
     * @return
     */
    @GetMapping("/index")
    public String hello3(){
        return "/index.html";
    }
}
