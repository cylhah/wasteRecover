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
     * @return 返回插入的数量
    */
    int insertCollector(Collector collector);

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
     * 根据手机号和密码查询回收员
     * @param phoneNumber
     * @param password
     * @return
     */
    Collector selectByPhoneNumAndPass(String phoneNumber,String password);

    /**
     * 按身份证号查找回收员
     * @param idCardNum 身份证号
     * @return
     */
    Collector selectByIdCardNum(String idCardNum);

    /**
     * 按名字搜索废品回收员
     * @param name
     * @param offset 偏移量
     * @param limit 限制数量
     * @return Collector列表，找不到list.size()=0
     */
    List<Collector> selectByName(String name,int offset,int limit);

    /**
     * 更改电话号码
     * @param id
     * @param phoneNumber
     * @return 返回更新记录的数量
     */
    int updatePhoneNum(int id,String phoneNumber);

    /**
     * 根据id更换密码
     * @param id
     * @param password
     * @return 返回更新记录的数量
     */
    int updatePassword(int id,String password);


    /**
     * 增加成交量
     * @param id
     * @return 返回成交量，<1代表增加失败
     */
    int addVolume(int id);

    /**
     * 更改个人资料
     * @param collector 存有id,sex,name,avater
     * @return 返回更新记录的数量
     */
    int updatePersonData(Collector collector);

    /**
     * 更改状态
     * @param id
     * @param state
     * @return 返回更新记录的数量
     */
    int updateState(int id,int state);

    /**
     * 删除回收员
     * @param id 存有id
     * @return 返回删除记录的数量
     */
     int deleteCollector(int id);
}
