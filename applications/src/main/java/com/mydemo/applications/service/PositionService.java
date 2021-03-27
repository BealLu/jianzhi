package com.mydemo.applications.service;

import com.mydemo.applications.entity.JzPosition;
import com.mydemo.applications.entity.PositionPojo;
import com.mydemo.applications.entity.PositionType;
import com.mydemo.applications.entity.SearchEntity;

import java.util.List;
import java.util.Map;

public interface PositionService {
    public int addPosition(PositionPojo positionPojo);
    public List<PositionType> findTypePid(Integer pid);
    public Map findDesc(Integer id,Integer userId);
    public List<JzPosition> findAllPosi(SearchEntity entity);
    public List<PositionType> findAllType();
    public int addgunzhu(Integer descId,Integer userId);
    public int remguanzhu(Integer descId,Integer userId);
    public int addPublish(Integer id);
    public int remPublish(Integer id);
    public PositionPojo findOne(Integer id);
    public int update(PositionPojo positionPojo);
}
