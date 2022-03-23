package com.example.vuespring.controller;

import com.example.vuespring.data.Member;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/hello")
    public String hello() {
        return "Api를 통해 Spring에서 Data 받아오기 성공";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody Member member) {

        System.out.println(member.getPassword());
        return "hi";
    }



}
