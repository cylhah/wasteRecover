package org.cbb.wasteRecovery.dao;

import org.apache.ibatis.annotations.Param;
import org.cbb.wasteRecovery.bean.Station;

import java.util.List;
import java.util.Map;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface StationDao {
    /**
     * 根据id查询回收站
     * @param id
     * @return
     */
    Station selectById(int id);


    /**
     * 根据地址模糊查询回收站
     * @param address
     * @param offset 偏移量
     * @param limit 数量
     * @return
     */

    List<Station> selectByAdd(@Param("address")String address,
                              @Param("offset")int offset,
                              @Param("limit")int limit);


    /**
     * 根据名字查询回收站
     * @param name
     * @param offset 偏移量
     * @param limit 数量
     * @return
     */

    List<Station> selectByName(@Param("name")String name,
                               @Param("offset")int offset,
                               @Param("limit")int limit);



    /**
     * 插入回收站
     * @param name
     * @param address
     * @param detailed_address
     * @param locationX
     * @param locationY
     * @return 返回插入的数量
     */

    int insertStaion(@Param("name")String name,
                     @Param("address")String address,
                     @Param("detailed_address")String detailed_address,
                     @Param("locationX")double locationX,
                     @Param("locationY")double locationY);


    /**
     * 根据id删除回收站
     * @param id
     * @return 返回删除的数量
     */
    int deleteStation(int id);

    /**
     * 更改回收站资料
     * @param station 存有 name,address,detailed_address,locationX,locationY
     * @return 返回更新的数量
     */
    int updateData(Station station);
}
