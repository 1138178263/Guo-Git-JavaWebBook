package com.atguigu.test;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
        if(userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用！");
        }else{
            System.out.println("用户名已存在！");
        }

    }

    @Test
    public void queryUserByUsernameAndPassword() {
        if(userDao.queryUserByUsernameAndPassword("123123","123123")==null){
            System.out.println("用户名或密码错误登录失败！");
        }else{
            System.out.println("用户名或密码正确登录成功！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null,"zhangsan","123456","113178263@qq.com")));
    }
}