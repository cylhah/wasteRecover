package org.cbb.wasteRecovery.dao;

import org.apache.ibatis.annotations.Param;
import org.cbb.wasteRecovery.bean.ScrapMessage;

import java.util.List;

public interface ScrapMessageDao {
    /**
     * 插入废品信息
     * @param oid
     * @param scrapid
     * @param weight
     * @param price
     * @return 返回插入数量
     */
    int insertScrapMessage(@Param("oid")long oid,
                           @Param("scrapid")int scrapid,
                           @Param("weight")double weight,
                           @Param("price")double price);

    /**
     * 删除废品信息
     * @param oid
     * @param scrapid
     * @return 返回删除数量
     */
    int deleteScrapMessage(@Param("oid")long oid,@Param("scrapid")int scrapid);

    /**
     * 更改信息资料
     * @param oid
     * @param scrapid 与oid形成联合主键
     * @param weight
     * @param price
     * @return 返回更新的数量
     */
    int updateData(@Param("oid")long oid,@Param("scrapid")int scrapid,
                   @Param("weight")double weight,@Param("price")double price);

}
