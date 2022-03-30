package com.example.vuespring.data;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @JsonBackReference
    @ManyToOne(targetEntity = Kind.class)
    @JoinColumn(name = "kind")
    private Kind kind;

    @JsonBackReference
    @ManyToOne(targetEntity = Member.class)
    @JoinColumn(name = "member")
    private Member member;

    public Menu(){}
    public Menu(int menuid, String menuname, int price, String ex, int stock, Kind kind, Member member, String fileload) {
        this.menuid = menuid;
        this.menuname = menuname;
        this.price = price;
        this.ex = ex;
        this.stock = stock;
        this.kind = kind;
        this.member = member;
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

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getFileload() {
        return fileload;
    }

    public void setFileload(String fileload) {
        this.fileload = fileload;
    }


}
