package org.cbb.wasteRecovery.service;


import org.cbb.wasteRecovery.bean.Community;
import org.cbb.wasteRecovery.bean.UserAddress;

public interface ManagementService {

    /**
     * 添加小区
     * @param userAddress
     * @return
     */
    boolean addUserAddress(UserAddress userAddress);

    /**
     * 删除小区
     * @param uaid
     * @return
     */
    boolean deleteUserAddress(String uaid);

    /**
     * 添加一个小区
     * @param community
     * @return
     */
    boolean addCommunity(Community community);

    /**
     * 更改小区资料
     * @param community
     * @return
     */
    boolean updateCommunity(Community community);

    /**删除小区
     * @param id
     * @return
     */
    boolean deleteCommunity(String id);

    /**
     * 删除回收员
     * @param id
     * @return
     */
    boolean deleteCollector(String id);

    /**
     * 删除咨询员
     * @param username
     * @return
     */
    boolean deleteConsultant(String username);

    /**
     * 根据id禁用回收员
     * @param id
     * @return 禁用成功返回true，失败返回false
     */
    boolean banCollector(String id);

    /**
     * 根据id恢复回收员权限
     * @param id
     * @return 恢复成功返回true
     */
    boolean recoverCollector(String id);

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
}
