package com.example.vuespring.controller;

import com.example.vuespring.data.Member;
import com.example.vuespring.repository.MemberRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;

@RestController
// @CrossOrigin("*")
@AllArgsConstructor  // @Autowired 대신사용
@RequestMapping("/api")
public class ApiController {

    MemberRepository memberRepository;

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



}
