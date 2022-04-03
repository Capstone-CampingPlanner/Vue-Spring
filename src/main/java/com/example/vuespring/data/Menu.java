package com.example.vuespring.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int menuid;

    @Column()
    private String menuname;
    private int price;
    private String ex;
    private LocalDateTime savedTime;
    private int stock;
    private String fileload;

    // fetch = FetchType.LAZY 쓰면 외래키 조회 불가 !


//    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kindid")
    private Kind kindid;

//    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userid")
//    @JsonIgnore
    private Member userid;

    public Menu(){}

    @Builder
    public Menu(int menuid, String menuname, int price, String ex, LocalDateTime savedTime, int stock, String fileload, Kind kindid, Member userid) {
        this.menuid = menuid;
        this.menuname = menuname;
        this.price = price;
        this.ex = ex;
        this.savedTime = savedTime;
        this.stock = stock;
        this.fileload = fileload;
        this.kindid = kindid;
        this.userid = userid;

    }



    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEx() {
        return ex;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public LocalDateTime getSavedTime() {
        return savedTime;
    }

    public void setSavedTime(LocalDateTime savedTime) {
        this.savedTime = savedTime;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getFileload() {
        return fileload;
    }

    public void setFileload(String fileload) {
        this.fileload = fileload;
    }

    public Kind getKindid() {
        return kindid;
    }

    public void setKindid(Kind kindid) {
        this.kindid = kindid;
    }

    public Member getUserid() {
        return userid;
    }

    public void setUserid(Member userid) {
        this.userid = userid;
    }
}
