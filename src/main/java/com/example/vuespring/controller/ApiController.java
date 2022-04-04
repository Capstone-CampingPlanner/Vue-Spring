package com.example.vuespring.controller;

import com.example.vuespring.data.Kind;
import com.example.vuespring.data.Member;
import com.example.vuespring.data.Menu;
import com.example.vuespring.dto.APIResponse;
import com.example.vuespring.dto.ProductDetailDTO;
import com.example.vuespring.repository.KindRepository;
import com.example.vuespring.repository.MemberRepository;
import com.example.vuespring.repository.MenuRepository;
import com.example.vuespring.service.MenuService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
//@CrossOrigin("*")
//@RequiredArgsConstructor
//@Slf4j
//@AllArgsConstructor  // @Autowired 대신사용
@RequestMapping("/api")
public class ApiController {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    KindRepository kindRepository;

    @Autowired
    MenuService menuService;

                                    /* 전체유저 리스트 */
    @GetMapping("/user_list")
//    @JsonProperty("member")
    public List memberList() {
        List members = memberRepository.findAll();
        return members;
    }

                                    /* 전체상품 리스트 */
    @GetMapping("/product_list")
//    @JsonProperty("menu")
    public List<Menu> menuList() {
        List<Menu> menus = menuRepository.findAll();
//        List<Menu> menuList = menuRepository.findAllByMemberList();

//        if (menus.isEmpty()) {
//            return null;
//        } else {
//            for (Menu m : menus) {
//                System.out.println(m.getKind().getKindname());
//                // return m.getKind().getKindname();
//            }
//        }
//        return menus;
            return menus;
    }
                                    /* 판매상품 상세 페이지 */
    @GetMapping("/product_detail/{menuid}")
    public Optional<Menu> getProduct_Detail(@PathVariable("menuid") int menuid) {
        System.out.println("메뉴번호 는" + menuid + "입니다.");

        Optional<Menu> menuDetailList = menuRepository.findById(menuid);
        return menuDetailList;

    }
                                    /* 나의상품 리스트 */
    @GetMapping("/myProduct_list/{userid}")
//    @JsonProperty("menu")
    public List<Menu> getMenuMyList(@PathVariable("userid") String userid) {

//        System.out.println(menuList.get(0).getKindid().getKindname());
//        List<Menu> myList = menuRepository.findAllByMenuList("dongmin");
        System.out.println(userid + " 분 의 상품을 조회하겠습니다.");
        Member user = menuService.findByMemberId(userid);
        List<Menu> menuMyList = menuRepository.findByUserid(user);
        return menuMyList;
    }
    // 한 행만 출력시 Optional , 전체 행은 List



                                    /* 회원가입 */
    @PostMapping("/signup")
//    @JsonProperty("member")
    public Member addMember(@RequestBody Member member) {

        if(member.getSavedTime()==null)
            member.setSavedTime(LocalDateTime.now());

        System.out.println(member.getPassword());
        memberRepository.save(member);
        return member;
    }

                                    /* 상품등록 페이지 */
    @PostMapping("/product_signup")
    public Menu addMenu(@RequestParam(value = "file_load", required = false) MultipartFile uploadFile, Menu menu, HttpServletRequest request) throws IllegalStateException, IOException {
        System.out.println("파일 이름" + uploadFile.getOriginalFilename());
        System.out.println("파일 크기" + uploadFile.getSize());

        // 경로지정
        String path = "C:\\Vue-Spring\\src\\main\\resources\\static\\images";

        // 파일명 충돌방지(랜덤함수) 설정후 파일저장
        UUID uuid = UUID.randomUUID();
        String uuidFilename = uuid + "_" + uploadFile.getOriginalFilename();
        File file = new File(path + uuidFilename);
        uploadFile.transferTo(file);

//        String path = request.getSession().getServletContext().getRealPath("/").concat("resources");
//        System.out.println("path"+path);

        if(menu.getSavedTime()==null)
            menu.setSavedTime(LocalDateTime.now());

        menu.setFileload(uploadFile.getOriginalFilename());
        menuRepository.save(menu);
        return menu;
    }

}

