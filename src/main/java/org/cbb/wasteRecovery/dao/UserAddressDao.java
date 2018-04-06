package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.UserAddress;

import java.util.List;

/**
 * Created by Colossus on 2018/3/20.
 */
public interface UserAddressDao {
    /**
 * 插入地址
 * @param userAddress 存有uid,address,locationX,locationY,detail,geohash
 */
   void insertAddress(UserAddress userAddress);

    /**
     * 根据id搜索地址
     * @param id
     * @return
     */
    UserAddress selectById(int id);
    /**
     * 根据uid搜索地址
     * @param uid 用户id
     * @return
     */
    List<UserAddress> selectByUid(int uid);

    /**
     * 更新地址
     * @param userAddress 存有id,uid,address,locationX,locationY,fullAdd,geohash
     */
    void updateAddress(UserAddress userAddress);



    /**
     * 根据id删除地址
     * @param id
     */
    void deleteAddress(int id);
}
