package com.example.vuespring.data;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="member")
public class Member {

    @Id
    private String userid;
    @Column(nullable=false, length=100)
    private String password;
    @Column()
    private String sales_type;
    @Column()
    private String payment;
    @Column()
    private String business_number;
    @Column()
    private LocalDateTime savedTime;


//    @JsonBackReference
//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member")
//    @JsonIgnore
//    private List<Menu> members;


    //
    public Member(){}
    public Member(String userid, String password){
        this.userid = userid;
        this.password = password;
    }

    //

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getSavedTime() {
        return savedTime;
    }

    public void setSavedTime(LocalDateTime savedTime) {
        this.savedTime = savedTime;
    }

    public String getSales_type() {
        return sales_type;
    }

    public void setSales_type(String sales_type) {
        this.sales_type = sales_type;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getBusiness_number() {
        return business_number;
    }

    public void setBusiness_number(String business_number) {
        this.business_number = business_number;
    }


}
