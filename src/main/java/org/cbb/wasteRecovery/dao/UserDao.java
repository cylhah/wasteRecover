package org.cbb.wasteRecovery.dao;

import org.apache.ibatis.annotations.Param;
import org.cbb.wasteRecovery.bean.User;

import java.util.Map;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface UserDao {
    /**
     * 插入用户
     * @param openid 微信的openid,用户的唯一识别码
     * @return 返回插入的数量
     */
    int insertUser( String openid);
    /**
     * 根据id查询用户
     * @param openid
     * @return
     */
    User selectById(String openid);

    /**
     * 根据openid禁止非法用户，使state变为0
     * @param openid
     * @return 返回更新的数量
    */
    int banUser(String openid);

    /**
     * 更改用户信息
     * @param openid
     * @param avater 头像地址
     * @return 返回更新的数量
     */
    int updateData(@Param("openid")String openid,@Param("avater")String avater);

  /**
   * 根据openid删除用户
   * @param openid
   * @return 返回删除的数量
   */
  int deleteUser(String openid);
}
