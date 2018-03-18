package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Scraptype;

/**
 * Created by Colossus on 2018/3/18.
 */
public interface ScraptypeDao {
    /**
     * 根据id查询废品种类
     * @param id
     * @return
     */
    Scraptype selectByid(int id);
    //管理废品，未做
}
