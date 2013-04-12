package com.shenghui.persistence.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


/**
 * User: xiangkui
 * Date: 13-4-7
 * Time: 下午10:14
 */

@Entity
@Table(name="MCatagory")
public class Mcatagory  implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    private String name;
//    @Version
//    private int version;

    public Mcatagory() {
    }


    public Mcatagory(String id) {
        this.id = id;
    }
    public Mcatagory(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
