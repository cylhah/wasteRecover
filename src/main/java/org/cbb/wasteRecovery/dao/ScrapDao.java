package org.cbb.wasteRecovery.dao;

import org.apache.ibatis.annotations.Param;
import org.cbb.wasteRecovery.bean.Scrap;
import org.cbb.wasteRecovery.entity.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface ScrapDao {

    /**
     * 插入废品
     * @param typeName
     * @param name
     * @param unitPrice
     * @return 返回插入的数量
     */
    int insertScrap(@Param("typeName")String typeName, @Param("name")String name,
                    @Param("unitPrice")double unitPrice);

    /**
     * 根据id搜索废品
     * @param id
     * @return
     */
    Scrap selectByid(int id);

    /**
     * 筛选废品
     * @param constrains 约束调教
     * @param page 分页属性
     * @return
     */
    List<Scrap> FilterScrapPage(@Param("constrains")Map constrains, @Param("page")Page page);


    /**
     * 更改废品信息
     * @param scrap 存有id,typeName,name,unitPrice
     * @return 返回更新数量
     */
    int updateData(Scrap scrap);

    /**
     * 增加成交量
     * @param id
     * @param volume
     * @return 返回更新数量
     */
    int AddVolume(@Param("id")int id,
                  @Param("volume")double volume);


    /**
     * 根据id删除废品
     * @param id
     * @return 返回删除数量
     */
    int deleteScrap(int id);
}
