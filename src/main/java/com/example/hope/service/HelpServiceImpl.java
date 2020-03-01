package com.example.hope.service;

import com.example.hope.bean.Help;
import com.example.hope.dao.HelpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Oji
 * @Date: 2020/03/01/9:35
 * @Description:
 */
@Service
public class HelpServiceImpl implements HelpService {
    @Autowired
    private HelpDao helpDao;

    @Override
    public int get(Help help) {
        return helpDao.selectId(help);
    }

    @Override
    public boolean join(Help help) {
        return helpDao.insert(help);
    }
}
