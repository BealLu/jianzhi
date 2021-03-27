package com.mydemo.manager.controller;

import com.mydemo.common.OSSTemplate;
import com.mydemo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
public class uploadController {
    @Autowired
    private OSSTemplate ossTemplate;
    @RequestMapping("/upload")
    public Result upload(MultipartFile file)  {

        //获得文件拓展名
        String originalFilename = file.getOriginalFilename();
        String exName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String fielName= UUID.randomUUID().toString()+"."+exName;
        String upload;
        try {
           upload = ossTemplate.upload(file.getInputStream(), fielName);
        } catch (IOException e) {
           return new Result(false,"文件上传失败");
        }
        return new Result(true,upload);
    }
}
