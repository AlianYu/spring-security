package com.springsecurity.springsecurity2.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springsecurity.springsecurity2.bean.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/17 9:20
 * @Version 1.0
 */
public interface UserService {

    List<User> getUserByUserName(QueryWrapper queryWrapper);
}
