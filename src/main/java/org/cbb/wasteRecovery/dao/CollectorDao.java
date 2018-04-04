package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Collector;

import java.util.List;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface CollectorDao {

    /**
 * 插入回收员，需要电话号码、名字、密码、性别、照片、身份证号、身份证正反照、创建时间
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
     *  按审核状态查找回收员
     * @param state
     * @return
     */
    List<Collector> selectByState(int state);



    /**
     * 根据collector中的id更改电话号码
     * @param collector 存有id
     */
    void updatePhoneNum(Collector collector);

    /**
     * 根据collector中的id更换密码
     * @param collector 存有id
     */
    void updatePassword(Collector collector);

    /**
     * 更改信用值
     * @param collector 存有id
     */
    void updateCreditValue(Collector collector);

    /**
     * 更改转账账户
     * @param collector 存有id
     */
    void updateAccount(Collector collector);

    /**
     * 增加成交量
     * @param collector 存有id
     */
    void addVolume(Collector collector);

    /**
     * 更改个人资料
     * @param collector 存有id,sex,name,email,avater
     */
    void updatePersonData(Collector collector);

}
