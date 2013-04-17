package com.shenghui.persistent.baseDao;

import java.io.Serializable;
import java.util.List;

/**
 * User: xiangkui
 * Date: 13-4-14
 * Time: 下午12:14
 */
public interface BaseDao<T> {
    T get(Class<T> tClass, Serializable id);
    List<T> getAll(Class<T> tClass);
    long  getCount(Class<T> tClass);
    void save(Object o);
    void remove(Object o);
    void update(Object o);

}
