package com.example.vuespring.controller;

import com.example.vuespring.data.Member;
import com.example.vuespring.data.Menu;
import com.example.vuespring.repository.MemberRepository;
import com.example.vuespring.repository.MenuRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
// @CrossOrigin("*")
@AllArgsConstructor  // @Autowired 대신사용
@RequestMapping("/api")
public class ApiController {

    MemberRepository memberRepository;
    MenuRepository menuRepository;

    @GetMapping("/hello")
    @JsonProperty("member")
    public List memberList() {
        List members = memberRepository.findAll();
        return members;
    }

    @PostMapping("/signup")
    @JsonProperty("member")
    public Member addMember(@RequestBody Member member) {

        if(member.getSavedTime()==null)
            member.setSavedTime(LocalDateTime.now());

        System.out.println(member.getPassword());
        memberRepository.save(member);
        return member;
    }

    @PostMapping("/product_signup")
    public Menu addMenu(@RequestParam(value = "file_load", required = false) MultipartFile uploadFile, Menu menu) throws IOException {
        System.out.println("파일 이름" + uploadFile.getOriginalFilename());
        System.out.println("파일 크기" + uploadFile.getSize());

        if(menu.getSavedTime()==null)
            menu.setSavedTime(LocalDateTime.now());

        menu.setFileload(uploadFile.getOriginalFilename());
        menuRepository.save(menu);
        return menu;
    }



}
