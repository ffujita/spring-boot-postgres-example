package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.DemoMessageDao;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoMessageDao dao;

    public DemoController(final DemoMessageDao dao) {
        this.dao = dao;
    }

    @GetMapping
    public String getMessage() {
        return dao.selectById(1);
    }
}
