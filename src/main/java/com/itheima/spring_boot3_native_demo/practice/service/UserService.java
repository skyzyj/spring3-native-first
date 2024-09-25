package com.itheima.spring_boot3_native_demo.practice.service;

import com.itheima.spring_boot3_native_demo.practice.entity.User;
import com.itheima.spring_boot3_native_demo.practice.entity.UserDetails;
import com.itheima.spring_boot3_native_demo.practice.vo.UserVO;

import java.util.List;

public interface UserService {
    List<UserDetails> getUserDetails();

    List<User> getUsers();
}
