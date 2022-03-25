package com.example.vuespring.data;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="kind")
public class Kind {

    @Id
    private int kindid;
    @Column()
    private String kindname;

    @JsonManagedReference
    @OneToMany
    @JoinColumn(name = "kind")
    private List<Menu> menus;


    public Kind() {}
    public Kind(int kindid, String kindname) {
        this.kindid = kindid;
        this.kindname = kindname;
    }


    public int getKindid() {
        return kindid;
    }

    public void setKindid(int kindid) {
        this.kindid = kindid;
    }

    public String getKindname() {
        return kindname;
    }

    public void setKindname(String kindname) {
        this.kindname = kindname;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
