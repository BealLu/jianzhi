package com.mydemo.manager.controller;

import com.mydemo.common.Result;
import com.mydemo.manager.entity.Content;
import com.mydemo.manager.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;
    @RequestMapping("/findAll")
    public List<Content> findAll(){
        return contentService.findAll();
    }
    @RequestMapping("/findOne")
    public Content findOne(Integer id){
        return contentService.findOne(id);
    }
    @RequestMapping("/dele")
    public Result dele(Integer[] ids){
        int dele = contentService.dele(ids);
        if (dele==1){
            return new Result(true,"删除成功!");
        }
        return new Result(false,"删除失败!");
    }
    @RequestMapping("/update")
    public Result update(@RequestBody Content content){
        int update = contentService.update(content);
        if (update>0){
            return new Result(true,"修改成功!");
        }
        return new Result(false,"修改失败!");
    }
    @RequestMapping("/add")
    public Result add(@RequestBody Content content){
        int add = contentService.add(content);
        if (add>0){
            return new Result(true,"添加成功!");
        }
        return new Result(false,"删除失败!");
    }
    @RequestMapping("/setStatus")
    public Result setStatus(Integer[] ids ,String status){
        int i = contentService.setStatus(ids, status);
        if (i>0){
            return new Result(true,"修改成功!");
        }
        return new Result(false,"修改失败!");
    }
}
