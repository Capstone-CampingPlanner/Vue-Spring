package com.example.vuespring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Api를 통해 Spring에서 Data 받아오기 성공";
    }

    @GetMapping("/api/signup")
    public String signup() { return ""; }
}
