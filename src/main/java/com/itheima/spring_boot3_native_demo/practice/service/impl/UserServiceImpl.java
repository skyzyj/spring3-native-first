package com.itheima.spring_boot3_native_demo.practice.service.impl;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.itheima.spring_boot3_native_demo.practice.dao.UserDao;
import com.itheima.spring_boot3_native_demo.practice.entity.User;
import com.itheima.spring_boot3_native_demo.practice.entity.UserDetails;
import com.itheima.spring_boot3_native_demo.practice.service.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, InitializingBean {

    private List<User> users = new ArrayList<>();

    @Autowired
    private UserDao userDao;

    @Override
    public List<UserDetails> getUserDetails() {
        return userDao.findUsers();
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //初始化时生成数据
        for (int i = 1; i <= 10; i++) {
            users.add(new User((long) i, RandomStringUtils.randomAlphabetic(10)));
        }
    }
}
