package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null,"bjpowernade","66666","23151512@qq.com"));
        userService.registUser(new User(null,"guigu","66666","23343512@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null,"123123","123123",null)));
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("zhangsan")){
            System.out.println("用户名已存在");
        }else{
            System.out.println("用户名可用");
        }
    }
}