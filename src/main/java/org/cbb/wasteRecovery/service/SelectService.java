package org.cbb.wasteRecovery.service;

import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.bean.Scrap;
import org.cbb.wasteRecovery.bean.UserAddress;
import org.cbb.wasteRecovery.entity.NeighborOrders;
import org.cbb.wasteRecovery.entity.Page;

import java.util.List;

public interface SelectService {
    /**
     * 根据经纬度查询附近订单
     * @param userAddress
     * @return
     */
    NeighborOrders selectOrdersByPos(UserAddress userAddress);

    /**
     * 根据用户openid查询订单
     * @param openid
     * @param page
     * @return
     */
    List<Orderform> selectOrdersByUid(String openid, Page page);

    /**
     * 根据openid查询地址
     * @param openid
     * @return
     */
    List<UserAddress> selectAddressByUid(String openid);

    /**
     * 根据回收员所选条件筛选订单
     * @param orderform
     * @param page
     * @return
     */
    List<Orderform> FilterOrders(Orderform orderform,Page page);

    /**
     * 根据订单id查询订单详细信息
     * @param oid
     * @return
     */
    Orderform selectOrderByOid(String oid);

    /**
     * 根据id查询回收员详细信息
     * @param cid
     * @return
     */
    Collector selectCollectorByCid(String cid);

    /**
     * 筛选回收员
     * @param collector
     * @param page
     * @return
     */
    List<Collector> FilterCollector(Collector collector,Page page);

    /**
     * 筛选废品
     * @param scrap
     * @param page
     * @return
     */
    List<Scrap> FilterScraps(Scrap scrap,Page page);


}
