package com.example.hope.dao;

import com.example.hope.bean.Help;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Oji
 * @Date: 2020/03/01/9:35
 * @Description:
 */
@Mapper
@Repository
public interface HelpDao {
    int selectId(Help help);

    boolean insert(Help help);
}
