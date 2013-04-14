package com.shenghui.persistent.entity;

/**
 * User: xiangkui
 * Date: 13-4-13
 * Time: 下午9:27
 */

import javax.persistence.*;

//省略import
@Entity
@Table(name="test")
public class UserModel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    private String myName;
    //省略getter和setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }
}