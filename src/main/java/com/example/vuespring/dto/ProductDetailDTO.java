package com.example.vuespring.dto;

import com.example.vuespring.data.Kind;
import com.example.vuespring.data.Member;
import com.example.vuespring.data.Menu;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Data
public class ProductDetailDTO {
    private int menuid;
    private String menuname;
    private int price;
    private String ex;
    private LocalDateTime savedTime;
    private int stock;
    private String fileload;

    private Kind kindid;
    private Member userid;

//    public Menu toEntity() {
//        return Menu.builder()
//                .menuid(menuid)
//                .menuname(menuname)
//                .price(price)
//                .ex(ex)
//                .savedTime(savedTime)
//                .stock(stock)
//                .fileload(fileload)
//                .kindid(kindid)
//                .userid(userid)
//                .build();
//    }

    public ProductDetailDTO(Menu menu) {
        this.menuname = menuname;
        this.menuid = menuid;
        this.price = price;
        this.ex = ex;
        this.savedTime = savedTime;
        this.stock = stock;
        this.fileload = fileload;
        this.kindid = kindid;
        this.userid = userid;
    }
}
