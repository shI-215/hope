package com.example.hope.service;

import com.example.hope.bean.User;

import java.util.Map;

public interface UserService {
    User login(User user);

    boolean register(User user);

    boolean find(User user);

    boolean alterPhone(Map<String, Object> map);

    boolean alterUser(User user);
}
