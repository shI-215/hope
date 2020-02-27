package com.example.hope.controller;

import com.alibaba.fastjson.JSON;
import com.example.hope.Application;
import com.example.hope.bean.User;
import com.example.hope.service.UserService;
import com.example.hope.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;
    private JsonResult jsonResult = new JsonResult();

    @PostMapping("/login")
    public JsonResult Login(@RequestBody User user) {
        System.out.println(user.toString());
        User user1 = userService.login(user);
        if (null != user1) {
            System.out.println(JSON.toJSONString(user1));
            jsonResult.setJsonResult(Application.SUCCESS_CODE, JSON.toJSONString(user1));
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "登录失败");
        }
        return jsonResult;
    }

    @PostMapping("/register")
    public JsonResult Register(@RequestBody User user) {
        boolean isRegister = userService.register(user);
        if (isRegister) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, "注册成功");
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "注册失败");
        }
        return jsonResult;
    }

    @PostMapping("/find")
    public JsonResult Find(@RequestBody User user) {
        boolean isFind = userService.find(user);
        if (isFind) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, "找回密码成功");
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "找回密码失败");
        }
        return jsonResult;
    }

    @PostMapping("/alterPhone")
    public JsonResult AlterPhone(@RequestParam("phone") String phone, @RequestParam("newPhone") String newPhone) {
        Map<String, Object> map = new HashMap<>();
        map.put("phone", phone);
        map.put("newPhone", newPhone);
        boolean isAlterPhone = userService.alterPhone(map);
        if (isAlterPhone) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, "手机修改成功");
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "手机修改失败");
        }
        return jsonResult;
    }

    @PostMapping("/alterUser")
    public JsonResult AlterUser(@RequestBody User user) {
        boolean isAlterUser = userService.alterUser(user);
        if (isAlterUser) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, "修改成功");
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "修改失败");
        }
        return jsonResult;
    }
}
