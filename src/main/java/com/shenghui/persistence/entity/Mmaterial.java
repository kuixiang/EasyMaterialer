package com.shenghui.persistence.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: xiangkui
 * Date: 13-4-7
 * Time: 下午10:57
 */
@Entity
@Table(name="MMaterial")
public class Mmaterial {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private String id;
    private String name;
    private String unit; //单位
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,
            CascadeType.REFRESH,CascadeType.MERGE})
    private Mcatagory mcatagory;

    @Version
    private int version;

    public  Mcatagory getMcatagory(){
        return mcatagory;
    }
    public void setMcatagory(Mcatagory mcatagory){
        this.mcatagory=mcatagory;
    }


}
