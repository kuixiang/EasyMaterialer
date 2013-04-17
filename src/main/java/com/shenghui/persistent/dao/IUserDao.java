package com.shenghui.persistent.dao;

import com.shenghui.persistent.entity.UserModel;

import java.io.Serializable;
import java.util.List;

/**
 * User: xiangkui
 * Date: 13-4-13
 * Time: 下午8:01
 */
public interface IUserDao {
    UserModel get(Serializable id);

    List getAll();

    void save(UserModel model);

    long countAll();
//    UserModel get(Class<UserModel> tClass, Serializable id);
//    public void save(UserModel model);
//    public int countAll();
}
