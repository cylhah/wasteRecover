package org.cbb.wasteRecovery.dao;

import org.apache.ibatis.annotations.Param;
import org.cbb.wasteRecovery.bean.Community;
import org.cbb.wasteRecovery.entity.Page;

import java.util.List;

public interface CommunityDao {
    /**
     * 插入小区
     * @param address
     * @param name
     * @return 返回插入的数量
     */
    int insertCommunity(@Param("address")String address,
                        @Param("name")String name);

    /**
     * 根据id删除受管理小区
     * @param id
     * @return 返回删除的数量
     */
    int deleteCommunity(int id);

    /**
     * 更改受管理回收员
     * @param id
     * @param cid
     * @return 返回更新的数量
     */
    int updateCollectorOfComm(@Param("id")int id,
                              @Param("cid")int cid);

    /**
     * 更改小区资料
     * @param name;
     * @param address ;
     * @return 返回更新的数量
     */
    int updateData(@Param("id")int id,@Param("name")String name,@Param("address")String address);

    /**
     * 根据回收人员id搜索小区
     * @param cid
     * @return 小区列表，找不到list.size()==0
     */
    List<Community> selectByCid(@Param("cid")int cid, @Param("page")Page page);

    /**
     * 根据名字模糊查询小区
     * @param name
     * @param offset 偏移量
     * @param limit 限制数量
     * @return
     */
    List<Community> selectByName(@Param("name")String name,
                                 @Param("offset")int offset,
                                 @Param("limit")int limit);
}
