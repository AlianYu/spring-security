package com.springsecurity.springsecurity2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springsecurity.springsecurity2.bean.User;
import org.springframework.stereotype.Component;

import java.security.acl.Owner;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/17 9:19
 * @Version 1.0
 */
@Component
public interface UserMapper extends BaseMapper<User> {

}
