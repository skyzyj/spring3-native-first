package com.itheima.spring_boot3_native_demo.practice.dao.impl;

import com.itheima.spring_boot3_native_demo.practice.dao.UserDao;
import com.itheima.spring_boot3_native_demo.practice.entity.UserDetails;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao, InitializingBean {

    //提前准备好数据
    private List<UserDetails> users = new ArrayList<>();

    /*
       模拟下数据库查询接口，主要目的是只优化Java代码，屏蔽SQL相关的内容
     */
    @Override
    public List<UserDetails> findUsers() {
        return users;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //初始化时生成数据
        for (int i = 1; i <= 10; i++) {
            users.add(new UserDetails((long) i, LocalDateTime.now(),new Date()));
        }
    }
}
