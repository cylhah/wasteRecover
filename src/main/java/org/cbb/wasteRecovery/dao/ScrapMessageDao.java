package org.cbb.wasteRecovery.dao;

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
    int insertScrapMessage(String oid,int scrapid,double weight,double price);

    /**
     * 删除废品信息
     * @param oid
     * @param scrapid
     * @return 返回删除数量
     */
    int deleteScrapMessage(String oid,int scrapid);

    /**
     * 更改信息资料
     * @param oid
     * @param scrapid 与oid形成联合主键
     * @param weight
     * @param price
     * @return 返回更新的数量
     */
    int updateData(String oid,int scrapid,double weight,double price);

    /**
     * 根据订单id查询废品信息
     * @param oid
     * @param offset 偏移量
     * @param limit 数量
     * @return
     */
    List<ScrapMessage> selectByOId(long oid,int offset,int limit);

    /**
     * 根据废品id查询订单信息
     * @param scrapId
     * @param offset 偏移量
     * @param limit 数量
     * @return
     */
    List<ScrapMessage> selectByScId(int scrapId,int offset,int limit);
}
