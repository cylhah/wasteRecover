package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Collector;

import java.util.List;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface CollectorDao {

    /**
     * 插入回收员，存有realName,sex,phoneNumber,password,photo,idCardNum,
     * idCardFrontPhoto,idCardBackPhoto,createTime,staid,state
     * @param collector
    */
    void InsertCollector(Collector collector);

    /**
     * 按id搜索废品回收员
     * @param id
     * @return Collector对象，找不到为null
     */
    Collector selectById(int id);

    /**
     * 按电话号码查找回收员
     * @param phoneNumber
     * @return
     */
    Collector selectByPhoneNum(String phoneNumber);

    /**
     * 按电话号码和密码查找回收员
     * @param collector
     * @return
     */
    Collector selectByPhoneNumAndPass(Collector collector);

    /**
     * 按身份证号查找回收员
     * @param idCardNum 身份证号
     * @return
     */
    Collector selectByIdCardNum(String idCardNum);

    /**
     * 按名字搜索废品回收员
     * @param name
     * @return Collector列表，找不到list.size()=0
     */
    List<Collector> selectByName(String name);

    /**
     * 根据collector中的id更改电话号码
     * @param collector 存有id与电话号码
     */
    void updatePhoneNum(Collector collector);

    /**
     * 根据collector中的id更换密码
     * @param collector 存有id
     */
    void updatePassword(Collector collector);


    /**
     * 增加成交量
     * @param collector 存有id
     */
    void addVolume(Collector collector);

    /**
     * 更改个人资料
     * @param collector 存有id,sex,name,avater
     */
    void updatePersonData(Collector collector);

    /**
     * 更改状态
     * @param collector 存有id,state
     */
    void updateState(Collector collector);

    /**
     * 删除回收员
     * @param collector 存有id
     */
    void deleteCollector(Collector collector);
}
