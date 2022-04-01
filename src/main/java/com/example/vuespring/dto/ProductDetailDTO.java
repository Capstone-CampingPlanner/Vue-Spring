package com.example.vuespring.dto;

import com.example.vuespring.data.Kind;
import com.example.vuespring.data.Member;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
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
}
