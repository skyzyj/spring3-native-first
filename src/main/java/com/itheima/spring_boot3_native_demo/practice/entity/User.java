package com.itheima.spring_boot3_native_demo.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
}
