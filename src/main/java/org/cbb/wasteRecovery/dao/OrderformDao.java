package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Orderform;

import java.util.List;
import java.util.Map;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface OrderformDao {
    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    Orderform selectById(long id);

    /**
     * 根据回收人员id查询订单
     * @param cid
     * @return
     */
    List<Orderform> selectByCId(int cid);

    /**
     *  根据用户id查询订单
     * @param uid
     * @return
     */
    List<Orderform> selectByUId(int uid);

    /**
     * 根据员工id查询订单
     * @param eid
     * @return
     */
    List<Orderform> selectByEId(int eid);

    /**
     * 根据订单状态查询订单
     * @param state
     * @return
     */
    List<Orderform> selectByState(int state);

    /**
     *  根据位置、订单状态、预约时间查找订单
     * @param map 存有appointSTime,appointETime,position,state
     * @return
     */
    List<Orderform> selectByPosAndTime(Map map);

    /**
     * 根据预约时间查询订单
     * @param orderform 存有appointSTime,appointETime
     * @return
     */
    List<Orderform> selectByTime(Orderform orderform);

    /**
     * 插入订单,设置state为1
     * @param orderform 存有uid,weight,createTime,appointSTime,appointETime,scraptypelist
     */
    void insertOrderform(Orderform orderform);

    /**
     * 更改订单重量
     * @param orderform 存有id,weight
     */
    void updateWeight(Orderform orderform);

    /**
     * 更改订单状态
     * @param orderform 存有id,state
     */
    void updateState(Orderform orderform);

    /**
     * 更改订单资料，需要判断属性非空
     * @param orderform 存有cid,eid,weight,price,state
     */
    void updateData(Orderform orderform);

    /**
     * 根据id删除订单
     * @param id
     */
    void deleteOrderform(long id);
}
