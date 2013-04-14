package com.shenghui.persistence.entity;

import com.shenghui.persistent.dao.IUserDao;
import com.shenghui.persistent.entity.UserModel;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.List;

/**
 * User: xiangkui
 * Date: 13-4-13
 * Time: 下午8:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
//        "classpath:/applicationContext-resources.xml",
        "classpath:/jpa/applicationContext-jpa.xml"
})
public class JPATest {
    EntityManagerFactory entityManagerFactory;
    PlatformTransactionManager txManager;
    JpaTemplate jpaTemplate;
    IUserDao userDao;
    @Before
    public void setUp() throws SQLException {
        //id自增主键从0开始
        String createTableSql = "CREATE   TABLE `test` (\n" +
                "`id`  int NULL AUTO_INCREMENT ,\n" +
                "`name`  varchar(100) NULL ,\n" +
                "PRIMARY KEY (`id`)\n" +
                ")";
        executeSql(createTableSql);
    }

    private void executeSql(String sql) throws SQLException {
        EntityManager em = entityManagerFactory.createEntityManager();
        beginTransaction(em);
        em.createNativeQuery(sql).executeUpdate();
        commitTransaction(em);
        closeEntityManager(em);
    }
    private void closeEntityManager(EntityManager em) {
        em.close();
    }
    private void rollbackTransacrion(EntityManager em) throws SQLException {
        if(em != null) {
            em.getTransaction().rollback();
        }
    }
    private void commitTransaction(EntityManager em) throws SQLException {
        em.getTransaction().commit();
    }
    private void beginTransaction(EntityManager em) throws SQLException {
        em.getTransaction().begin();
    }
    @Test
    public void testFirst() throws SQLException {
        UserModel model = new UserModel();
        model.setMyName("test");
        EntityManager em = null;
        try {
            em = entityManagerFactory.createEntityManager();
            beginTransaction(em);
            em.persist(model);
            commitTransaction(em);
        } catch (SQLException e) {
            rollbackTransacrion(em);
            throw e;
        } finally {
            closeEntityManager(em);
        }
    }

    @Test
    public void testJpaTemplate() {
        final UserModel model = new UserModel();
        model.setMyName("test1");
        new TransactionTemplate(txManager).execute(
                new TransactionCallback<Void>() {
                    @Override
                    public Void doInTransaction(TransactionStatus status) {
                        jpaTemplate.persist(model);
                        return null;
                    }
                });
        String COUNT_ALL = "select count(*) from UserModel";
        Number count = (Number) jpaTemplate.find(COUNT_ALL).get(0);
        Assert.assertEquals(1, count.intValue());
    }


    @Test
    public void testBestPractice() {
        UserModel model = new UserModel();
        model.setMyName("test");
        userDao.save(model);
        Assert.assertEquals(1, userDao.countAll());
    }
    @Test
    public void testCRUD() {
        TransactionTemplate tansactionTemplate = new TransactionTemplate(txManager);
        tansactionTemplate.execute(new TransactionCallback<Void>() {
            @Override
            public Void doInTransaction(TransactionStatus status) {
                UserModel model = new UserModel();
                model.setMyName("test");
                //新增
                jpaTemplate.persist(model);
                //修改
                model.setMyName("test2");
                jpaTemplate.flush();//可选
                //查询
                String sql = "from UserModel where myName=?";
                List result = jpaTemplate.find(sql, "test2");
                Assert.assertEquals(1, result.size());
                //删除
                jpaTemplate.remove(model);
                return null;
            }
        });
    }

    @After
    public void tearDown() throws SQLException {
        String dropTableSql = "drop table test";
        executeSql(dropTableSql);
    }
    //getter and setter
    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    @Autowired
    public void setTxManager(PlatformTransactionManager txManager) {
        this.txManager = txManager;
    }
    @Autowired
    public void setCatagoryDao(IUserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setJpaTemplate(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }
}
