package org.cbb.wasteRecovery.dao;

import com.sun.tools.corba.se.idl.constExpr.Or;
import org.apache.ibatis.annotations.Param;
import org.cbb.wasteRecovery.bean.Orderform;

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
                        @Param("uid")String uid);
    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    Orderform selectById(long id);

    List<Orderform> filterOrder(Map constrains);

    /**
     * 根据回收人员id和订单状态查询订单
     * @param cid
     * @param state
     * @param offset 偏移量
     * @param limit 数量
     * @return
     */
    List<Orderform> selectByCId(@Param("cid")int cid,@Param("state")int state,
                                @Param("offset")int offset,@Param("limit")int limit);

    /**
     *  根据用户id和订单状态查询订单
     * @param uid
     * @param state
     * @param offset 偏移量
     * @param limit 限制数量
     * @return
     */
    List<Orderform> selectByUId(@Param("uid")String uid,@Param("state")int state,
                                @Param("offset")int offset,@Param("limit")int limit);


    /**
     * 根据订单状态查询订单
     * @param state
     * @param offset 偏移量
     * @param limit 限制数量
     * @return
     */
    List<Orderform> selectByState(@Param("state")int state,
                                  @Param("offset")int offset,
                                  @Param("limit")int limit);

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
