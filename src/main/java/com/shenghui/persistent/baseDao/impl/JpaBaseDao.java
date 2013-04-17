package com.shenghui.persistent.baseDao.impl;

import com.shenghui.persistent.baseDao.BaseDao;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.jpa.JpaTemplate;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * User: xiangkui
 * Date: 13-4-14
 * Time: 下午12:18
 */

public abstract class JpaBaseDao<T> implements BaseDao<T> {
    JpaTemplate jpaTemplate;

    @Override
    public T get(Class<T> tClass, Serializable id) {
        return (T) getJpaTemplate().find(tClass, id);
    }

    @Override
    public List<T> getAll(Class<T> tClass) {
        return (List<T>) getJpaTemplate().findByNamedQuery(tClass.getName());
    }

    @Override
    public long getCount(Class<T> tClass) {
        String name=tClass.getName();
        name=name.substring(name.lastIndexOf('.')+1);
        String countSql="select count("
                +name.toLowerCase()+
                ") from "+name+" "+name.toLowerCase();
        return (Long)getJpaTemplate().find(countSql).get(0);
    }

    @Override
    public void save(Object o) {
        getJpaTemplate().persist(o);
    }

    @Override
    public void remove(Object o) {
        getJpaTemplate().remove(o);
    }

    @Override
    public void update(Object o) {
        getJpaTemplate().refresh(o);
    }

    //getter and setter

    public void setJpaTemplate(JpaTemplate jpaTemplate) {
        this.jpaTemplate = jpaTemplate;
    }

    public JpaTemplate getJpaTemplate() {
        return jpaTemplate;
    }
}
