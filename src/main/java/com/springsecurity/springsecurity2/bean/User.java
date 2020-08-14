package com.springsecurity.springsecurity2.bean;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/13 15:07
 * @Version 1.0
 */
@Data
public class User {
    private String username;
    private String password;
    private String roles;

}
