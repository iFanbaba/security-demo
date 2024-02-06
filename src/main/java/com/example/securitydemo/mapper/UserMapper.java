package com.example.securitydemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.securitydemo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @create 2024/2/6
 * @create 15:08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
