
package com.mydemo.manager.controller;

import com.mydemo.common.Result;
import com.mydemo.manager.entity.JzPosition;
import com.mydemo.manager.entity.PositionDesc;
import com.mydemo.manager.entity.PositionType;
import com.mydemo.manager.service.PositionAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/audit")
public class PositionAuditController {
    @Autowired
    private PositionAuditService positionAuditService;
    @RequestMapping("/findAllList")
    public List<PositionType> findAllList(){
        return positionAuditService.findAllList();
    }
    @RequestMapping("/findAllPosi")
    public List<JzPosition> findAllPosi(){
        return positionAuditService.findAllPosi();
    }
    @RequestMapping("/setStatus")
    public Result setSatus(Integer[] ids,String status){
        int i = positionAuditService.SetStaus(ids, status);
        //System.out.println(ids+"======="+status);
        if (i==1){
            return new Result(true,"修改成功");
        }
        return new Result(false,"修改失败");
    }
    @RequestMapping("/findDesc")
    public PositionDesc findDesc(Integer id){
        return positionAuditService.findDesc(id);
    }
    @RequestMapping("/findBySta")
    public List<JzPosition> findBySta(String sta){
        return positionAuditService.findBySta(sta);
    }
}
