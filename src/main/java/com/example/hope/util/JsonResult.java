package com.example.hope.util;

import com.example.hope.bean.User;

public class JsonResult {
    private int code = 200;//状态码{200-成功；400-异常；500-错误}
    private String data = null;//返回数据

    public JsonResult() {
    }

    public JsonResult(int code, String data) {
        this.code = code;
        this.data = data;
    }

    public void setJsonResult(int code, String data) {
        this.setCode(code);
        this.setData(data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
