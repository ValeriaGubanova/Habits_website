package com.javapoint.habits.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/client")
    public String showClient() {
        return "client";
    }
}

