package com.example.hope.dao;

import com.example.hope.bean.Active;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActiveDao {
    int insert(Active active);

    boolean delete(int actId);

    Active selectById(int actId);

    List<Active> selectAll();
}
