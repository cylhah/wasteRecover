package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.ScrapMessage;

import java.util.List;

public interface ScrapMessageDao {
    /**
     * 插入废品信息
     * @param scrapMessage 存有oid,scrapid,weight,price
     */
    void insertScrapMessage(ScrapMessage scrapMessage);

    /**
     * 删除废品信息
     * @param scrapMessage 存有oid,scrapid
     */
    void deleteScrapMessage(ScrapMessage scrapMessage);

    /**
     * 更改信息资料
     * @param scrapMessage 存有scrapid,weight,price
     */
    void updateData(ScrapMessage scrapMessage);

    /**
     * 根据订单id查询废品信息
     * @param oid
     * @return
     */
    List<ScrapMessage> selectByOId(long oid);

    /**
     * 根据废品id查询订单信息
     * @param scrapId
     * @return
     */
    List<ScrapMessage> selectByScId(int scrapId);
}
