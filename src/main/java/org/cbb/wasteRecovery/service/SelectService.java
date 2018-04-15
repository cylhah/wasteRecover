package org.cbb.wasteRecovery.service;


import org.cbb.wasteRecovery.bean.*;
import org.cbb.wasteRecovery.entity.Page;
import org.cbb.wasteRecovery.enums.OrderStateEnum;
import org.cbb.wasteRecovery.enums.UserStateEnum;

import java.util.List;

public interface SelectService {

    /**
     * 根据真实姓名查找回收员
     * @param realName
     * @param page
     * @return
     */
    List<Collector> selectCollByName(String realName, Page page);

    /**
     * 根据id查询回收员
     * @param id
     * @return
     */
    Collector selectCollById(int id);

    /**
     * 根据电话号码查询回收员
     * @param phoneNumber
     * @return
     */
    Collector selectCollByPhoneNum(String phoneNumber);

    /**
     * 按身份证号查找回收员
     * @param idCardNum 身份证号
     * @return
     */
    Collector selectCollByIdCardNum(String idCardNum);

    /**
     * 根据订单状态查询订单信息
     * @param orderStateEnum 订单状态
     * @param page 页面属性
     * @return
     */
    List<Orderform> selectOrders(OrderStateEnum orderStateEnum, Page page);
    /**
     * 根据订单状态查询此回收员订单
     * @param collector
     * @param orderStateEnum 订单状态
     * @param page 页面属性
     * @return
     */
    List<Orderform> selectOrders(Collector collector, OrderStateEnum orderStateEnum, Page page);

    /**
     * 根据订单状态查询此用户订单
     * @param user          ..
     * @param orderStateEnum ..
     * @param page  ..
     * @return
     */
    List<Orderform> selectOrders(User user, OrderStateEnum orderStateEnum, Page page);

    /**
     * 根据订单状态查询此小区订单
     * @param community ..
     * @param orderStateEnum ..
     * @param page ..
     * @return
     */
    List<Orderform> selectOrders(Community community,OrderStateEnum orderStateEnum,Page page);

    /**
     * 根据id查询咨询员
     * @param id
     * @return
     */
    Consultant selectConsultant(int id);

    /**
     * 根据回收站id查询咨询员
     * @param staid
     * @return
     */
    List<Consultant> selectConsultantByStaId(int staid,Page page);

    /**
     * 根据废品类型名查询废品
     * @param typeName
     * @param page
     * @return
     */
    List<Scrap> selectScrapByTypeName(String typeName,Page page);

    /**
     * 根据废品名模糊查询废品
     * @param name
     * @param page
     * @return
     */
    List<Scrap> selectScrapByName(String name,Page page);

    /**
     * 根据id查询回收站
     * @param id
     * @return
     */
    Station selectStation(int id);

    /**
     * 根据地址模糊查询回收站
     * @param address
     * @return
     */
    List<Station> selectStationByAddress(String address);

    /**
     * 根据小区名模糊查询回收站
     * @param name
     * @return
     */
    List<Station> selectStationByName(String name);

    /**
     * 根据openId查询用户
     * @param openid
     * @return
     */
    User selectUserById(String openid);

    /**
     * 根据状态查询用户
     * @param page
     * @param userStateEnum
     * @return
     */
    List<User> selectUser(UserStateEnum userStateEnum,Page page);
}
