package com.example.hope.service;

import com.example.hope.bean.Help;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Oji
 * @Date: 2020/03/01/9:34
 * @Description:
 */
public interface HelpService {
    int get(Help help);

    boolean join(Help help);
}
