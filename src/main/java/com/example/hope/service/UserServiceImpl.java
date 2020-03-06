package com.example.hope.service;

import com.example.hope.bean.User;
import com.example.hope.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
        return userDao.selectUser(user);
    }

    @Override
    public boolean register(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public boolean find(User user) {
        return userDao.updateUserPwd(user);
    }

    @Override
    public boolean alterPhone(Map<String, Object> map) {
        return userDao.updatePhone(map);
    }

    @Override
    public boolean alterUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User getImage(Integer userId) {
        return userDao.selectUserImage(userId);
    }

    @Override
    public boolean alterRegistrationID(User user) {
        return userDao.updateRegistrationID(user);
    }
}
