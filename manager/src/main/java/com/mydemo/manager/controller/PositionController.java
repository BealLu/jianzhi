package com.mydemo.manager.controller;

import com.mydemo.common.OSSTemplate;
import com.mydemo.common.Result;
import com.mydemo.manager.entity.PositionType;
import com.mydemo.manager.service.PositionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private OSSTemplate ossTemplate;
    @Autowired
    private PositionTypeService positionTypeService;
    @RequestMapping("/findByPid")
    public List<PositionType> findPositionByPid(Integer pid){
        return positionTypeService.findPositionByPid(pid);
    }
    @RequestMapping("/findOne")
    public PositionType findOne(int id){
        return positionTypeService.findOne(id);
    }
    @RequestMapping("/updatePositionType")
    public Result updatePositionType(@RequestBody PositionType positionType){
        if (positionTypeService.updatePositionType(positionType)>0){
            return new Result(true,"修改成功!");
        }
        return new Result(false,"修改失败!");
    }
    @RequestMapping("/addPositionType")
    public Result addPositionType(@RequestBody PositionType positionType){
        if (positionTypeService.addPositionType(positionType)>0){
            return new Result(true,"增加成功!");
        }
        return new Result(false,"增加失败!");
    }
    @RequestMapping("/dele")
    public Result dele(Integer[] ids) throws Exception {
        int dele = positionTypeService.dele(ids);
        if (dele==1){
            return new Result(true,"删除成功!");
        }
        if (dele==-1){
            return new Result(false,"当前选择的分类下拥有子分类,无法删除!");
        }
        return new Result(false,"删除失败!");
    }
    @RequestMapping("/upload")
    public String upload() throws FileNotFoundException {
        InputStream in=new FileInputStream("D:\\1.jpg");
        String url = ossTemplate.upload(in, "mypic.jpg");
        return url;
    }
}
