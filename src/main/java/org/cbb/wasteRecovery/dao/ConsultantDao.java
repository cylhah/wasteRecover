package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Consultant;

import java.util.List;

public interface ConsultantDao {
    /**
     * 插入咨询员，存有staid,username,password
     * @param staid
     * @param username
     * @param password
     * @return 返回插入的数量
     */
    int insertConsultant(int staid,int username,int password);

    /**
     * 根据id删除咨询员
     * @param id
     * @return 返回删除的数量
     */
    int deleteConsultant(int id);

    /**
     * 更改staid
     * @param id
     * @param staid
     * @return 返回更新的数量
     */
    int updateStaId(int id,int staid);

    /**
     * 更改密码
     * @param id
     * @param password
     * @return 返回更新的数量
     */
    int updatePassword(int id ,String password);

    /**
     * 根据用户名查询咨询员，查不到返回null
     * @param username
     * @return
     */
    Consultant selectByUsername(String username);

    /**
     * 根据用户名和密码查询咨询员
     * @param username
     * @param password
     * @return
     */
    Consultant selectByUsernameAndPass(String username,String password);

    /**
     * 根据staionid查询咨询员
     * @param staid
     * @return
     */
    List<Consultant> selectByStaId(int staid,int offset);
}
