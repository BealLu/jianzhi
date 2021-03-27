package com.mydemo.manager.service;

import com.mydemo.manager.entity.Content;

import java.util.List;

public interface ContentService {
    public List<Content> findAll();
    public Content findOne(int id);
    public int dele(Integer[] id);
    public int update(Content content);
    public int add(Content content);
    public int setStatus(Integer[] ids,String status);
}
