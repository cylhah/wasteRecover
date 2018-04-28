package org.cbb.wasteRecovery.service;

import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.bean.ScrapMessage;
import org.cbb.wasteRecovery.entity.OrderformExecute;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TradeService {
    /**
     * 用户提交订单
     * @param orderform 订单对象，包含订单信息
     * @return 插入成功返回true,失败返回false
     */
    OrderformExecute submitOrderform(Orderform orderform);

    /**
     * 回收员接受订单
     * @param orderform
     * @return
     */
    boolean receiveOrderform(Orderform orderform);

    /**
     * 用户请求取消订单,
     * @param id 订单id
     * @return 请求提交成功返回true，失败返回false
     */
    boolean requestCancleOrder(String id);


    /**！需要事务管理
     * 回收员完成订单,需要插入多条scrapMessage信息并提交总重量及价格
     * @param orderform
     * @return ...
     */
    OrderformExecute completeOrder(Orderform orderform);


    /**
     * 对已完成的订单进行评分
     * @param orderform
     * @return
     */
    boolean gradeOrderform(Orderform orderform);

    /**
     * 回收员取消订单(只能取消state==3||state==4的订单)
     * @param id
     * @return ...
     */
    boolean cancelOrder(String id);

}
