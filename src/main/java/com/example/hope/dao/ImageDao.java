package com.example.hope.dao;

import com.example.hope.bean.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ImageDao {

    boolean insertImage(List<Image> list);

    List<Image> selectAllImage();

    List<Image> selectMyImage(int uId);

    List<Image> selectAllMyImage(int uId);

    List<Image> selectActiveImage(int actId);
}
