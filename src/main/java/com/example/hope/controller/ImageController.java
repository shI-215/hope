package com.example.hope.controller;

import com.alibaba.fastjson.JSON;
import com.example.hope.Application;
import com.example.hope.bean.Image;
import com.example.hope.service.ImageService;
import com.example.hope.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/image")
public class ImageController {
    private JsonResult jsonResult = new JsonResult();

    @Autowired
    private ImageService imageService;

    /**
     * 查询所有图片
     *
     * @return
     */
    @GetMapping("/lookAllImage")
    public JsonResult lookAllImage() {
        List<Image> iList = imageService.lookAllImage();
        if (iList.size() != 0) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, JSON.toJSONString(iList));
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "查询失败");
        }
        return jsonResult;
    }

    /**
     * 查看当前用户图片
     *
     * @param uId
     * @return
     */
    @GetMapping("/lookMyImage")
    public JsonResult lookMyImage(@RequestParam int uId) {
        List<Image> iList = imageService.lookMyImage(uId);
        if (iList.size() != 0) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, JSON.toJSONString(iList));
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "查询失败");
        }
        return jsonResult;
    }

    /**
     * 查看当前用户的所有图片
     *
     * @param uId
     * @return
     */
    @GetMapping("/lookAllMyImage")
    public JsonResult lookAllMyImage(@RequestParam int uId) {
        List<Image> iList = imageService.lookAllMyImage(uId);
        if (iList.size() != 0) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, JSON.toJSONString(iList));
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "查询失败");
        }
        return jsonResult;
    }
}
