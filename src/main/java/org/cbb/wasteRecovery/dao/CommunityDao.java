package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Community;

import java.util.List;

public interface CommunityDao {
    /**
     * 插入受管理小区
     * @param community 存有address,cid,name
     */
    void insertCommunity(Community community);

    /**
     * 根据id删除受管理小区
     * @param id
     */
    void deleteCommunity(int id);

    /**
     * 更改受管理回收员
     * @param community 存有id,cid
     */
    void updateCollector(Community community);

    /**
     * 更改小区名
     * @param community
     */
    void updateName(Community community);

    /**
     * 根据回收人员id搜索小区
     * @param cid
     * @return 小区列表，找不到list.size()==0
     */
    List<Community> selectByCid(int cid);

    /**
     * 根据名字模糊查询小区
     * @param name
     * @return
     */
    List<Community> selectByName(String name);
}
