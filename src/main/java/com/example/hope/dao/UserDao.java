package com.example.hope.dao;

import com.example.hope.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface UserDao {

    User selectUser(User user);

    boolean insertUser(User user);

    boolean updateUserPwd(User user);

    boolean updatePhone(Map<String, Object> map);

    boolean updateUser(User user);

    User selectUserImage(Integer userId);
}
