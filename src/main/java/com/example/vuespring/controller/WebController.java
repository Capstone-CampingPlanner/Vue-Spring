package com.example.vuespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
