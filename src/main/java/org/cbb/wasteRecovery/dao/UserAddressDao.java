package org.cbb.wasteRecovery.dao;

import org.apache.ibatis.annotations.Param;
import org.cbb.wasteRecovery.bean.UserAddress;

import java.util.List;

/**
 * Created by Colossus on 2018/3/20.
 */
public interface UserAddressDao {
    /**
     * 插入地址
     * @param uid 用户id
     * @param address 地址
     * @param detail  地址详细信息
     * @param geohash 用于查找附近订单的hash码
     * @param locationX  经度
     * @param locationY 纬度
     * @param community_id 受管理小区
     * @param name 用户姓名
     * @param phoneNumber 电话号码
     * @return 返回插入的数量
    */
   int insertAddress(UserAddress userAddress);

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
    List<UserAddress> selectByUid(@Param("uid")String uid);

    /**
     * 更新地址
     * @param userAddress 存有id,uid,address,locationX,locationY,fullAdd,geohash
     * @return 返回更新的数量
     */
    int updateAddress(UserAddress userAddress);



    /**
     * 根据id删除地址
     * @param id
     * @return 返回更新的数量
     */
    int deleteAddress(int id);
}
