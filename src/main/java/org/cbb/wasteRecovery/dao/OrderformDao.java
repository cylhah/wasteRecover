package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.bean.Orderform;

import java.util.List;
import java.util.Map;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface OrderformDao {
    /**
 * 插入订单,设置state为1
 * @param orderform 存有weight,createTime,appointTime,aid,uid
 */
  void insertOrderform(Orderform orderform);
    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    Orderform selectById(long id);

    /**
     * 根据回收人员id和订单状态查询订单
     * @param orderform cid,state
     * @return
     */
    List<Orderform> selectByCId(Orderform orderform);

    /**
     *  根据用户id和订单状态查询订单
     * @param orderform 存有uid,state
     * @return
     */
    List<Orderform> selectByUId(Orderform orderform);


    /**
     * 根据订单状态查询订单
     * @param state
     * @return
     */
    List<Orderform> selectByState(int state);

  /**
   * 更改订单信息
   * @param orderform 存有id,aid,appointTime
   */
  void updateOrderform(Orderform orderform);

    /**
     * 提交订单资料，需要判断属性非空
     * @param orderform 存有id,cid,weight,price,state
     */
    void submitData(Orderform orderform);

    /**
     * 根据id删除订单
     * @param id
     */
    void deleteOrderform(long id);
}
