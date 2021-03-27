package com.mydemo.manager.service.impl;

import com.mydemo.manager.entity.*;
import com.mydemo.manager.mapper.JzPositionMapper;
import com.mydemo.manager.mapper.PositionDescMapper;
import com.mydemo.manager.mapper.PositionTypeMapper;
import com.mydemo.manager.service.PositionAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionAuditServiceImpl implements PositionAuditService {
    @Autowired
    private PositionTypeMapper positionTypeMapper;
    @Autowired
    private JzPositionMapper jzPositionMapper;
    @Autowired
    private PositionDescMapper positionDescMapper;
    @Override
    public List<PositionType> findAllList() {
        List<PositionType> positionTypes = positionTypeMapper.selectByExample(null);
        return positionTypes;
    }

    @Override
    public List<JzPosition> findAllPosi() {
        JzPositionExample example =new JzPositionExample();
        JzPositionExample.Criteria criteria = example.createCriteria();
        criteria.andIspublishEqualTo("1");//只能审核已发布的兼职
        return jzPositionMapper.selectByExample(example);
    }

    @Override
    public int SetStaus(Integer[] ids, String status) {
        try {
            for (Integer id : ids) {
                JzPosition jzPosition = jzPositionMapper.selectByPrimaryKey(id);
                jzPosition.setStatus(status);
                jzPositionMapper.updateByPrimaryKey(jzPosition);
            }
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    @Override
    public PositionDesc findDesc(Integer id) {
        return positionDescMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<JzPosition> findBySta(String sta) {
        if (sta==""||sta==null){
            return jzPositionMapper.selectByExample(null);
        }
      JzPositionExample example=new JzPositionExample();
        JzPositionExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(sta);
        return jzPositionMapper.selectByExample(example);
    }

}
