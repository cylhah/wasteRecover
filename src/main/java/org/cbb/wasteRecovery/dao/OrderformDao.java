package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Orderform;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface OrderformDao {
    /**
     * 插入订单,设置state为1
     * @param createTime 预约时间
     * @param appointTime 用户时间
     * @param aid
     * @param uid
     * @param state
     * @return 返回插入的数量
     */
    int insertOrderform(Timestamp createTime,Timestamp appointTime,
                        int aid,String uid,int state);
    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    Orderform selectById(long id);

    /**
     * 根据回收人员id和订单状态查询订单
     * @param cid
     * @param state
     * @param offset 偏移量
     * @param limit 数量
     * @return
     */
    List<Orderform> selectByCId(int cid,int state,int offset,int limit);

    /**
     *  根据用户id和订单状态查询订单
     * @param uid
     * @param state
     * @param offset 偏移量
     * @param limit 限制数量
     * @return
     */
    List<Orderform> selectByUId(String uid,int state,int offset,int limit);


    /**
     * 根据订单状态查询订单
     * @param state
     * @param offset 偏移量
     * @param limit 限制数量
     * @return
     */
    List<Orderform> selectByState(int state,int offset,int limit);

  /**
   *  根据位置信息查询订单
   * @param locationX 经度
   * @param locationY 纬度
   * @param geohash 用于附近距离查找的hash码
   * @param distance 限制距离
   * @param offset 偏移量
   * @param limit 限制数量
   * @return
   */
  List<Orderform> selectByPositon(double locationX,double locationY,
                                  String geohash,double distance,
                                  int offset,int limit);

  /**
   * 更改订单信息
   * @param id
   * @param aid
   * @param appointTime
   * @return 返回更新数量
   */
  int updateOrderform(long id, int aid, Timestamp appointTime);

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
