package com.example.hope.service;

import com.example.hope.bean.Image;
import com.example.hope.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    public boolean addImage(List<Image> list) {
        return imageDao.insertImage(list);
    }

    @Override
    public List<Image> lookAllImage() {
        return imageDao.selectAllImage();
    }

    @Override
    public List<Image> lookMyImage(int uId) {
        return imageDao.selectMyImage(uId);
    }
}
