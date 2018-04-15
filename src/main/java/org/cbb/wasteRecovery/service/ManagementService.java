package org.cbb.wasteRecovery.service;


import org.cbb.wasteRecovery.bean.Community;

public interface ManagementService {
    /**
     * 根据id禁用回收员
     * @param id
     * @return 禁用成功返回true，失败返回false
     */
    boolean banCollector(int id);

    /**
     * 根据id恢复回收员权限
     * @param id
     * @return 恢复成功返回true
     */
    boolean recoverCollector(int id);

    /**
     * 根据id禁用用户
     * @param openId
     * @return
     */
    boolean banUser(String openId);

    /**
     * 根据id恢复用户
     * @param openId
     * @return
     */
    boolean recoverUser(String openId);

    /**
     * 添加一个小区
     * @param community
     * @return
     */
    boolean addCommunity(Community community);

    /**
     * 给回收员分配小区
     * @param community
     * @return
     */
    boolean distributeCommunity(Community community);

    /**
     * 更改小区地址和名字
     * @param community
     * @return
     */
    boolean changeCommunityAddress(Community community);

    /**删除小区
     * @param id
     * @return
     */
    boolean deleteCommunity(int id);

    /**
     * 删除回收员
     * @param id
     * @return
     */
    boolean deleteCollector(int id);

    /**
     * 删除咨询员
     * @param id
     * @return
     */
    boolean deleteConsultant(int id);
}
