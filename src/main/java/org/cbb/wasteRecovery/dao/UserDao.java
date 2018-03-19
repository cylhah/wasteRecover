package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.User;

import java.util.Map;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface UserDao {
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UserDao selectById(int id);

    /**
     * 根据手机号码查询用户
     * @param phoneNumber
     * @return
     */
    UserDao selectByPhoneNumber(String phoneNumber);

    /**
     * 根据手机号码和密码查询用户
     * @param user 存有password与phoneNumber
     * @return
     */
    UserDao selectByPhoneAndPass(User user);

    /**
     * 插入用户
     * @param user 存有phoneNumber,name,password
     */
    void insertUser(User user);

    /**
     * 更新地址
     * @param map 存有id,UserAddress
     */
    void updateAddress(Map map);

    /**
     * 更改用户信息
     * @param user 存有id,name,sex,email,bankAccount,avater
     */
    void updateData(User user);
}