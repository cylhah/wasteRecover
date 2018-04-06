package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.User;

import java.util.Map;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface UserDao {
    /**
     * 插入用户
     * @param user 存有openId,state
     */
    void insertUser(User user);
    /**
     * 根据id查询用户
     * @param openid
     * @return
     */
    User selectById(String openid);

    /**
     * 根据openid禁止非法用户，使state变为0
     * @param openid
    */
    void banUser(String openid);

    /**
     * 更改用户信息
     * @param user 存有id,avater
     */
    void updateData(User user);

  /**
   * 根据openid删除用户
   * @param openid
   */
  void deleteUser(String openid);
}
