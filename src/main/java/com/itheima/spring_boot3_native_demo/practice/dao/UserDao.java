package com.itheima.spring_boot3_native_demo.practice.dao;

import com.itheima.spring_boot3_native_demo.practice.entity.UserDetails;

import java.util.List;

public interface UserDao {
    List<UserDetails> findUsers();
}
