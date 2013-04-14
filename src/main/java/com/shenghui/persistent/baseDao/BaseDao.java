package com.shenghui.persistent.baseDao;

import java.io.Serializable;
import java.util.List;

/**
 * User: xiangkui
 * Date: 13-4-14
 * Time: 下午12:14
 */
public interface BaseDao<T> {
    T get(Serializable id);
    List<T> getAll();
    void save(Object o);
    void remove(Object o);
    void update(Object o);
}
