package com.shenghui.persistent.dao.jdbc;

import com.shenghui.persistent.baseDao.impl.JpaBaseDao;
import com.shenghui.persistent.dao.IUserDao;
import com.shenghui.persistent.entity.UserModel;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * User: xiangkui
 * Date: 13-4-13
 * Time: 下午8:04
 */
@Transactional(propagation = Propagation.REQUIRED)
public class UserDaoImpl extends JpaBaseDao implements IUserDao {
    private static final String INSERT_SQL = "insert into test(name) values(:myName)";
    @Override
    public UserModel get(Serializable id) {
        return (UserModel) super.get(UserModel.class, id);
    }

    @Override
    public List getAll() {
        return (List) super.getAll(UserModel.class);
    }

    @Override
    public void save(UserModel model) {
        super.save(model);
    }

    @Override
    public long countAll() {
        return super.getCount(UserModel.class);
    }

}
