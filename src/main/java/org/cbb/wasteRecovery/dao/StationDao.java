package org.cbb.wasteRecovery.dao;

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
     * @return
     */
    List<Station> selectByAdd(String address);

    /**
     * 根据名字查询回收站
     * @param name
     * @return
     */
    List<Station> selectByName(String name);


    /**
     * 插入回收站
     * @param station 存有name,address,detailed_address,locationX,locationY
     */
    void insertStaion(Station station);

    /**
     * 根据id删除回收站
     * @param id
     */
    void deleteStation(int id);

    /**
     * 更改回收站资料
     * @param station 存有 name,address,detailed_address,locationX,locationY
     */
    void updateData(Station station);
}
