package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Scrap;

import java.util.List;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface ScrapDao {

    /**
     * 插入废品
     * @param typeName
     * @param name
     * @param uintPrice
     * @return 返回插入的数量
     */
    int insertScrap(String typeName,String name,String uintPrice);

    /**
     * 根据id搜索废品
     * @param id
     * @return
     */
    Scrap selectByid(int id);

    /**
     * 根据废品名精确查找
     * @param typeName typeName
     * @param offset 偏移量
     * @param limit 限制数量
     * @return
     */
    List<Scrap> selectByTypeName(String typeName,int offset,int limit);


    /**
     * 更改废品信息
     * @param scrap 存有id,typeName,name,unitPrice
     * @return 返回更新数量
     */
    int updateData(Scrap scrap);

    /**
     * 更改当月成交量（重量）
     * @param id
     * @param monthVolume
     * @return 返回成交量(<0更新失败，即不存在该id)
     */
    double updateMonthVolume(int id,double monthVolume);

    /**
     * 更改总成交量
     * @param id
     * @param totalVolume
     * @return 返回成交量(<0更新失败，即不存在该id)
     */
    double updateTotalVolume(int id,double totalVolume);

    /**
     * 根据id删除废品
     * @param id
     * @return 返回删除数量
     */
    int deleteScrap(int id);
}
