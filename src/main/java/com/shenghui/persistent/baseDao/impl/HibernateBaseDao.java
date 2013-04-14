package com.shenghui.persistent.baseDao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.shenghui.persistent.baseDao.BaseDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.persistence.EntityManagerFactory;

/**
 * User: xiangkui
 * Date: 13-4-14
 * Time: 下午12:18
 */

public class HibernateBaseDao<T> extends HibernateDaoSupport implements BaseDao<T> {
    private EntityManagerFactory entityManagerFactory;
    private Class<T> entityClass;
    public HibernateBaseDao() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        entityClass =  (Class)params[0];
    }
    public T get(Serializable id) {
        return (T)getHibernateTemplate().load(entityClass, id);
    }
    public List<T> getAll() {
        return getHibernateTemplate().loadAll(entityClass);
    }
    public void save(Object o) {
        getHibernateTemplate().saveOrUpdate(o);
    }
    public void remove(Object o) {
        getHibernateTemplate().delete(o);
    }
    public void update(Object o) {
        getHibernateTemplate().update(o);
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

}
