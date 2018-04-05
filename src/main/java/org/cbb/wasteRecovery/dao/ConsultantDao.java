package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.Consultant;

import java.util.List;

public interface ConsultantDao {
    /**
     * 插入咨询员，存有staid,username,password
     * @param consultant
     */
    void insertConsultant(Consultant consultant);

    /**
     * 根据id删除咨询员
     * @param id
     */
    void deleteConsultant(int id);

    /**
     * 更改staid
     * @param consultant 存有id,staid
     */
    void updateStaId(Consultant consultant);

    /**
     * 更改密码
     * @param consultant 存有id,password
     */
    void updatePassword(Consultant consultant);

    /**
     * 根据用户名查询咨询员，查不到返回null
     * @param username
     * @return
     */
    Consultant selectByUsername(String username);

    /**
     * 根据用户名和密码查询咨询员
     * @param consultant
     * @return
     */
    Consultant selectByUsernameAndPass(Consultant consultant);

    /**
     * 根据staionid查询咨询员
     * @param staid
     * @return
     */
    List<Consultant> selectByStaId(int staid);
}
