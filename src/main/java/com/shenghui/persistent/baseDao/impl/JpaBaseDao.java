package com.shenghui.persistent.baseDao.impl;

import com.shenghui.persistent.baseDao.BaseDao;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.jpa.JpaTemplate;

import javax.persistence.EntityManagerFactory;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * User: xiangkui
 * Date: 13-4-14
 * Time: 下午12:18
 */

public class JpaBaseDao<T>  implements BaseDao<T> {
    JpaTemplate jpaTemplate;

    @Override
    public T get(Serializable id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<T> getAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void save(Object o) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void remove(Object o) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Object o) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    //getter and setter

    public void setJpaTemplate(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }

    public JpaTemplate getJpaTemplate() {
        return jpaTemplate;
    }
}
