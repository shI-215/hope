package com.example.hope.controller;

import com.example.hope.Application;
import com.example.hope.bean.Help;
import com.example.hope.service.HelpService;
import com.example.hope.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: Oji
 * @Date: 2020/03/01/10:26
 * @Description:
 */
@RestController
@RequestMapping(value = "/help")
public class HelpControll {
    private JsonResult jsonResult = new JsonResult();

    @Autowired
    private HelpService helpService;

    @PostMapping("/join")
    public JsonResult join(@RequestParam("actId") int actId, @RequestParam("userId") int userId) {
        Help help = new Help();
        help.setUserId(userId);
        help.setActId(actId);
        boolean isJoin = helpService.join(help);
        if (isJoin) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, "1");
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "0");
        }
        return jsonResult;
    }
}
