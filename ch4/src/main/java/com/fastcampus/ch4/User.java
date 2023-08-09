package com.fastcampus.ch4;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 데이타베이스에서 사용할 엔티티 클래스
 */
@Entity
public class User {
    @Id
    @Column(name = "user_id")
    private String id;
    private String password;
    private String name;
    private String email;
    //FetchType.EAGER ; 두 앤티티 정보를 같이 가져옴(join)
    //FetchType.LAZY ; 따로 가져오는 것. 나중에 getList() 기본값
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    List<Board> list = new ArrayList<>();

    public List<Board> getList() {
        return list;
    }

    public void setList(List<Board> list) {
        this.list = list;
    }

    private Date inDate; //입력일
    private Date upDate; //변경일

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", list=" + list +
                ", inDate=" + inDate +
                ", upDate=" + upDate +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }
}
