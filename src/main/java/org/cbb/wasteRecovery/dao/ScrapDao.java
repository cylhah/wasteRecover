package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Scrap;

import java.util.List;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface ScrapDao {

    /**
     * 插入废品
     * @param scrap 存有typeName,name,unitPrice
     */
    void insertScrap(Scrap scrap);

    /**
     * 根据id搜索废品
     * @param id
     * @return
     */
    Scrap selectByid(int id);

    /**
     * 根据废品名精确查找
     * @param typeName typeName
     * @return
     */
    List<Scrap> selectByTypeName(String typeName);


    /**
     * 更改废品信息
     * @param scrap 存有id,typeName,name,unitPrice
     */
    void updateData(Scrap scrap);

    /**
     * 更改当月成交量
     * @param scrap 存有id,monthVolume
     */
    void updateMonthVolume(Scrap scrap);

    /**
     * 更改总成交量
     * @param scrap 存有id,totalVolume
     */
    void updateTotalVolume(Scrap scrap);

    /**
     * 根据id删除废品
     * @param id
     */
    void deleteScrap(int id);
}
