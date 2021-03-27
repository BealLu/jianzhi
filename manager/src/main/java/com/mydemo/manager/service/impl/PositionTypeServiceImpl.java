package com.mydemo.manager.service.impl;

import com.mydemo.manager.entity.PositionType;
import com.mydemo.manager.entity.PositionTypeExample;
import com.mydemo.manager.mapper.PositionTypeMapper;
import com.mydemo.manager.service.PositionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
@Service
public class PositionTypeServiceImpl implements PositionTypeService {
    @Autowired
    private PositionTypeMapper positionTypeMapper;
    @Override
    public List<PositionType> findPositionByPid(int pid) {
        PositionTypeExample example=new PositionTypeExample();
        PositionTypeExample.Criteria criteria = example.createCriteria();
        criteria.andPidEqualTo(pid);
        List<PositionType> positionTypes = positionTypeMapper.selectByExample(example);
        return positionTypes;
    }

    @Override
    public PositionType findOne(int id) {
        return positionTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updatePositionType(PositionType positionType) {
        return positionTypeMapper.updateByPrimaryKey(positionType);
    }

    @Override
    public int addPositionType(PositionType positionType) {
        return positionTypeMapper.insert(positionType);
    }

    @Override
    public int dele(Integer[] ids)  {
        for (Integer id : ids) {
            PositionTypeExample example=new PositionTypeExample();
            example.createCriteria().andPidEqualTo(id);
            List<PositionType> positionTypes = positionTypeMapper.selectByExample(example);
            if (!CollectionUtils.isEmpty(positionTypes)){
               return -1;
            }
        }
            for (Integer id : ids) {
                positionTypeMapper.deleteByPrimaryKey(id);
            }
        return 1;
    }
}
