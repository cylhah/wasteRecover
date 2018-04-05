package org.cbb.wasteRecovery.dao;

public interface ScrapMessage {
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
}
