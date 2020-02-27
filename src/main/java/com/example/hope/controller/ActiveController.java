package com.example.hope.controller;

import com.alibaba.fastjson.JSON;
import com.example.hope.Application;
import com.example.hope.bean.Active;
import com.example.hope.bean.Image;
import com.example.hope.service.ActiveService;
import com.example.hope.service.ImageService;
import com.example.hope.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/active")
public class ActiveController {
    private String filePath = "E://Hope/images/";
    //    private String filePath = "/root/Hope/images/";
    @Autowired
    private ActiveService activeService;
    @Autowired
    private ImageService imageService;
    private JsonResult jsonResult = new JsonResult();

    @PostMapping("/release")
    public JsonResult Release(@RequestBody Active active) {
        System.out.println(active.toString());
        List<Map<String, Object>> images = FileController.getImages();
        System.out.println(images.toString());
        if (images.size() < 2) {
            jsonResult.setJsonResult(Application.FAILED_CODE, "发布失败,图片或证明未上传");
        } else {
            activeService.release(active);
            if (active.getActId() != 0) {
                List<Image> imageList = new ArrayList<>();
                for (Map map : images) {
                    Image image = new Image();
                    image.setImgPath(map.get("path").toString());
                    image.setImgType(Integer.parseInt(map.get("type").toString()));
                    image.setActive(active);
                    imageList.add(image);
                }
                System.out.println("imageList" + imageList);
                boolean isOk = imageService.addImage(imageList);
                if (isOk) {
                    jsonResult.setJsonResult(Application.SUCCESS_CODE, "发布成功");
                    FileController.clearImages();
                } else {
                    jsonResult.setJsonResult(Application.FAILED_CODE, "发布失败");
                }
            } else {
                jsonResult.setJsonResult(Application.FAILED_CODE, "发布失败");
            }
        }
        return jsonResult;
    }

    @GetMapping("/delete")
    public JsonResult Delete(@RequestParam int actId) {
        System.out.println(actId);
        boolean isDelete = activeService.delete(actId);
        if (isDelete) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, "删除成功");
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "删除失败");
        }
        return jsonResult;
    }

    @GetMapping("/look")
    public JsonResult Look(@RequestParam int actId) {
        System.out.println(actId);
        Active active = activeService.look(actId);
        if (null != active) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, JSON.toJSONString(active));
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "查询失败");
        }
        return jsonResult;
    }

    @GetMapping("/lookAll")
    public JsonResult LookAll() {
        List<Active> aList = activeService.lookAll();
        if (aList.size() != 0) {
            jsonResult.setJsonResult(Application.SUCCESS_CODE, JSON.toJSONString(aList));
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "查询失败");
        }
        return jsonResult;
    }
}
