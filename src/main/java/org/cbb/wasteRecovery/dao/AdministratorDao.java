package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Administrator;
import org.cbb.wasteRecovery.bean.Employee;

import java.util.List;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface AdministratorDao {
    /**
     * 根据用户名和密码查找出管理员
     * @param administrator
     * @return 管理员列表，没有查找到list.size()=0
     */
    List<Administrator> selectAdmin(Administrator administrator);

    /**
     *  根据用户名、密码、分拣站id插入管理员
     * @param administrator
     */
    void insertAdmin(Administrator administrator);

    /**
     * 更改管理员密码
     * @param employee 存有id,password
     */
    void updatePassword(Administrator administrator);

}
