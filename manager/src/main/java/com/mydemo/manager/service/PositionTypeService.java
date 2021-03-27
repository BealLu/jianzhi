package com.mydemo.manager.service;

import com.mydemo.manager.entity.PositionType;

import java.util.List;

public interface PositionTypeService {
    public List<PositionType> findPositionByPid(int pid);
    public PositionType findOne(int id);
    public int updatePositionType(PositionType positionType);
    public int addPositionType(PositionType positionType);
    public int dele(Integer[] ids) throws Exception;
}
