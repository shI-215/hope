package com.example.hope.service;

import com.example.hope.bean.Image;

import java.util.List;

public interface ImageService {

    boolean addImage(List<Image> list);

    List<Image> lookAllImage();

    List<Image> lookMyImage(int uId);

    List<Image> lookAllMyImage(int uId);

    List<Image> lookActiveImage(int actId);
}
