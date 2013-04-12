package com.shenghui.persistence.entity;


import junit.framework.TestCase;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: xiangkui
 * Date: 13-4-8
 * Time: 下午10:51
 */
public class McatagoryTest{
    @Test
    public void testDatabaseOption() throws Exception{
        EntityManagerFactory factory= Persistence.createEntityManagerFactory("openjpa");//形如sessionFactory
        EntityManager em=factory.createEntityManager();
        em.getTransaction().begin();
        Mcatagory mcatagory=new Mcatagory();
        mcatagory.setName("Light");
        em.persist(mcatagory);
        em.getTransaction().commit();
        em.close();
        factory.close();
    }
}
