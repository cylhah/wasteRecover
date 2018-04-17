package org.cbb.wasteRecovery.dao;

import org.apache.ibatis.annotations.Param;
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
    int insertConsultant(@Param("staid")int staid,
                         @Param("username")String username,
                         @Param("password")String password);

    /**
     * 根据id删除咨询员
     * @param username
     * @return 返回删除的数量
     */
    int deleteConsultant(String username);

    /**
     * 更改staid
     * @param username 用户名
     * @param staid
     * @return 返回更新的数量
     */
    int updateStaId(@Param("username")String username,
                    @Param("staid")int staid);

    /**
     * 更改密码
     * @param username
     * @param password
     * @return 返回更新的数量
     */
    int updatePassword(@Param("username")String username ,@Param("password")String password);

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
    Consultant selectByUsernameAndPass(@Param("username")String username,
                                       @Param("password")String password);

    /**
     * 根据staionid查询咨询员
     * @param staid
     * @param offset 偏移量
     * @param limit 数量
     * @return
     */
    List<Consultant> selectByStaId(@Param("staid")int staid,
                                   @Param("offset")int offset,
                                   @Param("limit")int limit);
}
