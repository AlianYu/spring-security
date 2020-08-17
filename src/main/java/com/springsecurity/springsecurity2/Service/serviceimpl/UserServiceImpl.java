package com.springsecurity.springsecurity2.Service.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springsecurity.springsecurity2.Service.UserService;
import com.springsecurity.springsecurity2.bean.User;
import com.springsecurity.springsecurity2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/17 9:22
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByUserName(QueryWrapper queryWrapper) {

        return userMapper.selectList(queryWrapper);
    }
}
