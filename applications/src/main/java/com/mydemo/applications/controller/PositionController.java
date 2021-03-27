package com.mydemo.applications.controller;

import com.mydemo.applications.entity.JzPosition;
import com.mydemo.applications.entity.PositionPojo;
import com.mydemo.applications.entity.PositionType;
import com.mydemo.applications.entity.SearchEntity;
import com.mydemo.applications.service.PositionService;
import com.mydemo.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;
    @RequestMapping("/addPosition")
    public Result addPosition(@RequestBody PositionPojo positionPojo){
        //System.out.println(positionPojo.toString());
        int i = positionService.addPosition(positionPojo);
        System.out.println(i);
        if (i==1){
            return new Result(true,"添加成功");
        }
        return new Result(false,"添加失败");
    }
    @RequestMapping("/update")
    public Result update(@RequestBody PositionPojo positionPojo){
        //System.out.println(positionPojo.toString());
        int i = positionService.update(positionPojo);
        System.out.println(i);
        if (i==1){
            return new Result(true,"更新成功");
        }
        return new Result(false,"更新失败");
    }
    @RequestMapping("/findTypePid")
    public List<PositionType> findTypePid(Integer pid){
        return positionService.findTypePid(pid);
    }
    @RequestMapping("/findDesc")
    public Map findDesc(Integer id,Integer userId){

        return positionService.findDesc(id,userId);
    }
    @RequestMapping("/findAllPosi")
    public List<JzPosition> findAllPosi(@RequestBody SearchEntity entity){
        //System.out.println(entity);
        return positionService.findAllPosi(entity);
    }
    @RequestMapping("/findAllType")
    public List<PositionType> findAllType(){

        return positionService.findAllType();
    }
    @RequestMapping("/addguanzhu")
    public Result addguanzhu(Integer descId,Integer userId){
        System.out.println(descId+"==="+userId);
        int addgunzhu = positionService.addgunzhu(descId, userId);
        if (addgunzhu==1){
            return new Result(true,"收藏成功");
        }
        return new Result(false,"收藏失败");
    }
    @RequestMapping("/remguanzhu")
    public Result remguanzhu(Integer descId,Integer userId){
        System.out.println(descId+"==="+userId);
        int addgunzhu = positionService.remguanzhu(descId, userId);
        if (addgunzhu==1){
            return new Result(true,"取消收藏成功");
        }
        return new Result(false,"取消收藏失败");
    }
    @RequestMapping("/remPublish")
    public Result remPublish(Integer id){
        System.out.println(id);
        int i = positionService.remPublish(id);
        if (i==1){
            return new Result(true,"操作成功");
        }
        return new Result(false,"操作失败");
    }
    @RequestMapping("/addPublish")
    public Result addPublish(Integer id){
        int i = positionService.addPublish(id);
        if (i==1){
            return new Result(true,"操作成功");
        }
        return new Result(false,"操作失败");
    }
    @RequestMapping("/findOne")
    public PositionPojo findOne(Integer id){
        return positionService.findOne(id);
    }
}
