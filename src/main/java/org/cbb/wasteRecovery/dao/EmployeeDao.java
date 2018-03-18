package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Employee;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface EmployeeDao {
    /**
     * 根据用户名查找员工
     * @param username
     * @return 查找不到返回null
     */
    Employee selectByUsername(String username);

    /**
     * 根据用户名与密码查找员工
     * @param employee 存有username,password
     * @return 查找不到null
     */
    Employee selectByNameAndPass(Employee employee);

    /**
     * 插入员工
     * @param employee 存有username,password,staid,adminid,createTime
     */
    void InsertEmployee(Employee employee);

    /**
     * 更改密码
     * @param employee 存有id,password
     */
    void updatePassword(Employee employee);
}
