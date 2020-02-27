package com.example.hope.controller;

import com.example.hope.Application;
import com.example.hope.util.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/file")
public class FileController {
    private JsonResult jsonResult = new JsonResult();
    private String filePath = "E://Hope/images/";
    //    private String filePath = "/root/Hope/images/";
    private static List<Map<String, Object>> images = new ArrayList<>();

    @PostMapping(value = "/upload")//单文件上传
    public JsonResult Upload(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            jsonResult.setJsonResult(Application.FAILED_CODE, "图片不能为空");
        } else {
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("文件名为：" + fileName + " 文件类型：" + suffixName);
            if (suffixName.equals(".png") || suffixName.equals(".jpg")) {
                String path = filePath + (System.currentTimeMillis() + suffixName);
                System.out.println(path);
                File dest = new File(path);
                if (!dest.getParentFile().exists()) {
                    dest.mkdirs();
                }
                file.transferTo(dest);
                Map<String, Object> map = new HashMap<>();
                map.put("path", path);
                map.put("type", 1);
                images.add(map);
                System.out.println(images.toString());
                jsonResult.setJsonResult(Application.SUCCESS_CODE, "图片上传成功");
            } else {
                jsonResult.setJsonResult(Application.FAILED_CODE, "文件格式错误");
            }
        }
        return jsonResult;
    }

    @PostMapping(value = "/download")//单文件下载
    public JsonResult Download(HttpServletResponse response) throws IOException {
        String path = filePath + "1581756621855.png";
        File file = new File(path);
        if (!file.exists()) {
            jsonResult.setJsonResult(Application.FAILED_CODE, "下载失败");
        } else {
            InputStream inputStream = new FileInputStream(path);
            OutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(bytes)) > 0) {
                outputStream.write(bytes, 0, len);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();
        }
        return jsonResult;
    }

    @PostMapping(value = "/uploadMore")//多文件上传
    public JsonResult UploadMore(@RequestParam("file") MultipartFile[] files) throws IOException {
        if (files.length < 1) {
            jsonResult.setJsonResult(Application.FAILED_CODE, "证明不能为空");
        } else {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getOriginalFilename();
                System.out.println(fileName);
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                String path = filePath + (System.currentTimeMillis() + suffixName);
                System.out.println(path);
                File dest = new File(path);
                if (!dest.exists()) {
                    dest.mkdirs();
                }
                files[i].transferTo(dest);
                Map<String, Object> map = new HashMap<>();
                map.put("path", path);
                map.put("type", 2);
                images.add(map);
            }
            System.out.println(images.toString());
            jsonResult.setJsonResult(Application.SUCCESS_CODE, "证明上传成功");
        }
        return jsonResult;
    }

    public static List getImages() {
        return images;
    }

    public static void clearImages() {
        images.clear();
        System.out.println(images.toString());
    }
}
