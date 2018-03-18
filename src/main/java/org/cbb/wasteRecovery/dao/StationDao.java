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
     * 根据位置信息查询回收站
     * @param map 存有回收人员的位置信息 ?详细暂定
     * @return
     */
    List<Station> selectByPos(Map map);

    /**
     * 根据地址查询回收站
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
     * 更改回收站资金
     * @param station
     */
    void updateMoney(Station station);


}
