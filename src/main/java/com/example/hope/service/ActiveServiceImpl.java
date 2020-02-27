package com.example.hope.service;

import com.example.hope.bean.Active;
import com.example.hope.dao.ActiveDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveServiceImpl implements ActiveService {
    @Autowired
    private ActiveDao activeDao;

    @Override
    public int release(Active active) {
        return activeDao.insert(active);
    }

    @Override
    public boolean delete(int actId) {
        return activeDao.delete(actId);
    }

    @Override
    public Active look(int actId) {
        return activeDao.selectById(actId);
    }

    @Override
    public List<Active> lookAll() {
        return activeDao.selectAll();
    }
}
