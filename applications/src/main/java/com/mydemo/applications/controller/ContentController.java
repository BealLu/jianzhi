package com.mydemo.applications.controller;

import com.mydemo.applications.entity.Content;
import com.mydemo.applications.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;
    @RequestMapping("/findContent")
    public List<Content> findContent(){
       return contentService.findContent();
    }
}
