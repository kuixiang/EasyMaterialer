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
    private static final String COUNT_ALL_SQL = "select count(*) from test";

    @Override
    public void save(UserModel model) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int countAll() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object get(Serializable id) {
        return super.get(id);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public List getAll() {
        return super.getAll();    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void save(Object o) {
        super.save(o);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void remove(Object o) {
        super.remove(o);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void update(Object o) {
        super.update(o);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
