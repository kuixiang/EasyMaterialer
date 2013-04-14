package com.shenghui.persistent.dao;

import com.shenghui.persistent.entity.UserModel;

/**
 * User: xiangkui
 * Date: 13-4-13
 * Time: 下午8:01
 */
public interface IUserDao {
    public void save(UserModel model);
    public int countAll();
}
