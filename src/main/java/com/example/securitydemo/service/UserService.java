package com.example.securitydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.securitydemo.entity.User;
import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * @create 2024/2/6
 * @create 15:10
 */
public interface UserService extends IService<User> {
    void saveUserDetails(User user);
}
