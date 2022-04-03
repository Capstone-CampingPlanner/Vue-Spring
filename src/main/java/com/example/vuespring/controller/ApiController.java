package com.example.vuespring.controller;

import com.example.vuespring.data.Kind;
import com.example.vuespring.data.Member;
import com.example.vuespring.data.Menu;
import com.example.vuespring.dto.APIResponse;
import com.example.vuespring.dto.ProductDetailDTO;
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
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
@AllArgsConstructor  // @Autowired 대신사용
@RequestMapping("/api")
public class ApiController {

    MenuService menuService;

    MemberRepository memberRepository;
    MenuRepository menuRepository;

    @GetMapping("/user_list")
    @JsonProperty("member")
    public List memberList() {
        List members = memberRepository.findAll();
        return members;
    }

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

    @GetMapping("/myProduct_list")
//    @JsonProperty("menu")
    public List<Menu> menuMyList() {

//        System.out.println(menuList.get(0).getKindid().getKindname());
//        List<Menu> myList = menuRepository.findAllByMenuList("dongmin");
        List<Menu> myMenus = menuRepository.findAll();
        return myMenus;
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

    // (api/{code})
    // pathvariable("code") code)


//    @GetMapping("/product_detail/{id}")
//    @JsonProperty("menu")
//    public List<Menu> productDetail(@PathVariable("id") Menu userid) {
//        List<Menu> productListDetail = menuRepository.findByUserid(userid);
//
//        return productListDetail;
//    }


    @GetMapping("/product_detail/{menuname}")
    public ResponseEntity<?> product_Detail(@PathVariable("menuname") String menuname) throws Exception {
        System.out.println("성공" + menuname);
        ResponseEntity<?> entity = null;

        entity = new ResponseEntity<ProductDetailDTO>(menuService.view(menuname), HttpStatus.OK);
        return entity;
    }
}

