package com.example.hope.service;

import com.example.hope.bean.Active;

import java.util.List;

public interface ActiveService {

    int release(Active active);

    boolean delete(int actId);

    Active look(int actId);

    List<Active> lookAll();
}
