package org.cbb.wasteRecovery.dao;

import org.apache.ibatis.annotations.Param;
import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.entity.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface CollectorDao {

    /**
     * 插入回收员，存有realName,sex,phoneNumber,password,photo,idCardNum,
     * idCardFrontPhoto,idCardBackPhoto,staid
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
     * 根据openid查询废品回收员
     * @param openid
     * @return
     */
    Collector selectByOpenid(String openid);


    /**
     * 根据手机号和密码查询回收员
     * @param phoneNumber
     * @param password
     * @return
     */
    Collector selectByPhoneNumAndPass(@Param("phoneNumber") String phoneNumber,
                                      @Param("password") String password);


    /**
     * 筛选回收员
     * @param constrains 筛选条件
     * @param page 分页属性
     * @return Collector列表，找不到list.size()=0
     */
    List<Collector> filterCollPage(@Param("constrains")Map constrains, @Param("page")Page page);


    /**
     * 更改个人资料
     * @param collector 存有id,sex,name,avater
     * @return 返回更新记录的数量
     */
    int updatePersonData(Collector collector);


    /**
     * 更改回收员资料
     * @param id
     * @param map 约束条件
     * @return
     */
    int updateData(@Param("id")int id,@Param("constrains")Map map);


    /**
     * 删除回收员
     * @param id 存有id
     * @return 返回删除记录的数量
     */
     int deleteCollector(int id);
}
