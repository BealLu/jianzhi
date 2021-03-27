package com.mydemo.applications.service;

import com.mydemo.applications.entity.IndexPojo;
import com.mydemo.applications.entity.PositionPojo;

import java.util.List;

public interface IndexService {
    List<IndexPojo> findNewPosi();
}
