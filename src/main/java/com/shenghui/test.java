package com.shenghui;

import com.shenghui.persistence.entity.Mcatagory;

import javax.persistence.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: xiangkui
 * Date: 13-4-7
 * Time: 下午10:04
 */
public class test {
    public static void main(String[] args){
        try{
            EntityManagerFactory emf= Persistence.createEntityManagerFactory("openjpa");
            EntityManager em=emf.createEntityManager();

            EntityTransaction tran=em.getTransaction();
            tran.begin();
            Mcatagory mcatagory=new Mcatagory();
//            mcatagory.setId("0");
            mcatagory.setName("cataName3");
            em.persist(mcatagory);
            tran.commit();
        }   catch (Exception e){
            e.printStackTrace();
        }

    }
}
