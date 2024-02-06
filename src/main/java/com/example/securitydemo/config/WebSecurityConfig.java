package com.example.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @create 2024/2/3
 * @create 12:39
 */
@Configuration//标识未配置类，启动时，将bean节点初始化在bean容器中
//@EnableWebSecurity
//开启spring security自定义配置，在springboot项目中，
//只要引入了spring-boot-starter-security，该注解可以省略
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        DBUserDetailsManager manager = new DBUserDetailsManager();
        return manager;
    }

    @Bean
    public UserDetailsManager userDetailsManager(){
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123456")
                .roles("USER").build());
        return userDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //authorizeRequests()：开启授权保护
        //anyRequest()：对所有请求开启授权保护
        //authenticated()：已认证请求会自动被授权
        http
                .authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                .formLogin(withDefaults())//表单授权方式
                .httpBasic(withDefaults());//基本授权方式
        return http.build();
    }
}
