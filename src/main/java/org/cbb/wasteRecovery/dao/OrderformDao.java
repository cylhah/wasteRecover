package org.cbb.wasteRecovery.dao;


import org.apache.ibatis.annotations.Param;
import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.entity.Page;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface OrderformDao {
    /**
     * 插入订单
     * @param appointTime 用户时间
     * @param aid
     * @param uid
     * @return 返回插入的数量
     */
    int insertOrderform(@Param("appointTime")Timestamp appointTime,
                        @Param("aid")int aid,
                        @Param("uid")String uid,
                        @Param("weightState")int weightState);
    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    Orderform selectById(long id);

    /**
     * 筛选订单，筛选条件不定
     * @param constrains
     * @return
     */
    List<Orderform> filterOrderPage(@Param("constrains") Map constrains, @Param("page")Page page);


    /**
     * 根据位置查询订单
     * @param geohash
     * @param locationX
     * @param locationY
     * @param distance
     * @return
     */
    List<Orderform> selectByPos(@Param("openid") String openid,
                                @Param("geohash") String geohash,
                                @Param("locationX") double locationX,
                                @Param("locationY") double locationY,
                                @Param("distance") double distance);


    /**
     * 更新订单状态
     * @param id
     * @param state 订单状态
     * @return
     */
    int updateOrderform(@Param("id") long id,@Param("state") int state);

    /**
     * 更新订单状态与回收人员
     * @param id
     * @param state 订单状态
     * @param cid 回收员id
     * @return
     */
    int updateCollectorAndState(@Param("id") long id,@Param("state") int state,@Param("cid") int cid);

    /**
     * 更新订单分数
     * @param id
     * @param rank
     * @return
     */
    int updateRank(@Param("id")long id,@Param("rank") int rank);
    /**
     * 提交订单资料，需要判断属性非空
     * @param orderform 存有id,cid,weight,price,state
     * @return 返回更新数量
     */
    int submitData(Orderform orderform);

    /**
     * 根据id删除订单
     * @param id
     * @return 返回删除的数量
     */
    int deleteOrderform(long id);
}
