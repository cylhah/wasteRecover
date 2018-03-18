package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Scrap;

import java.util.List;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface ScrapDao {
    /**
     * 根据tid搜索废品
     * @param tid
     * @return
     */
    List<Scrap> selectByTid(int tid);


    //管理成交量，未做
}
