package com.example.securitydemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.securitydemo.config.DBUserDetailsManager;
import com.example.securitydemo.entity.User;
import com.example.securitydemo.mapper.UserMapper;
import com.example.securitydemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @create 2024/2/6
 * @create 15:12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private DBUserDetailsManager dbUserDetailsManager;

    @Override
    public void saveUserDetails(User user) {


    }
}
