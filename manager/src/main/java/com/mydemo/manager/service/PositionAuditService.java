package com.mydemo.manager.service;

import com.mydemo.manager.entity.JzPosition;
import com.mydemo.manager.entity.PositionDesc;
import com.mydemo.manager.entity.PositionType;

import java.util.List;

public interface PositionAuditService {
    List<PositionType> findAllList();
    List<JzPosition> findAllPosi();
    int SetStaus(Integer[] ids,String status);
    PositionDesc findDesc(Integer id);
    List<JzPosition> findBySta(String sta);
}
