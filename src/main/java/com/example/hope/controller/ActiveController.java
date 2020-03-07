package com.example.hope.controller;

import com.alibaba.fastjson.JSON;
import com.example.hope.Application;
import com.example.hope.bean.Active;
import com.example.hope.bean.Help;
import com.example.hope.bean.Image;
import com.example.hope.service.ActiveService;
import com.example.hope.service.HelpService;
import com.example.hope.service.ImageService;
import com.example.hope.util.JPushUtil;
import com.example.hope.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/active")
public class ActiveController {

    private JsonResult jsonResult = new JsonResult();

    @Autowired
    private ImageService imageService;
    @Autowired
    private ActiveService activeService;
    @Autowired
    private HelpService helpService;

    /**
     * 活动发布
     *
     * @param active
     * @return
     */
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

    /**
     * 删除活动
     *
     * @param actId
     * @return
     */
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

    /**
     * 活动查看
     *
     * @param actId
     * @param userId
     * @return
     */
    @GetMapping("/look")
    public JsonResult Look(@RequestParam("actId") int actId, @RequestParam("userId") int userId) {
        Active active = activeService.look(actId);
        List<Image> iList = imageService.lookActiveImage(actId);
        Help help = new Help();
        help.setActId(actId);
        help.setUserId(userId);
        int helpId = helpService.get(help);
        if (null != active && iList.size() != 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("active", active);
            map.put("images", iList);
            if (helpId != 0) {
                map.put("isJoin", true);
            } else {
                map.put("isJoin", false);
            }
            System.out.println(JSON.toJSONString(map));
            jsonResult.setJsonResult(Application.SUCCESS_CODE, JSON.toJSONString(map));
        } else {
            jsonResult.setJsonResult(Application.FAILED_CODE, "查询失败");
        }
        return jsonResult;
    }

    /**
     * 查看所有活动
     *
     * @return
     */
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

    /**
     * 待开发项
     */
    //用户推送
    @GetMapping("/push")
    public void push() {
        String[] users = new String[1];
        Map<String, String> parm = new HashMap<String, String>();
        //设置提示信息,内容是文章标题
        parm.put("msg", "收到请联系发送人");
        parm.put("title", "这里是title");
//        parm.put("id", users);
        JPushUtil.jpushAndroidUser(parm, users);
    }
}
