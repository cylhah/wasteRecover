package org.cbb.wasteRecovery.dao;

import org.apache.ibatis.annotations.Param;
import org.cbb.wasteRecovery.bean.BankAccount;

import java.util.List;

public interface BankAccountDao {
    /**
     * 插入银行账户
     *
     * @param uid
     * @param account
     * @param bank_code
     * @param username
     * @return 返回插入的数量
     */

    int insertBankAccount(@Param("uid") String uid,
                          @Param("account") String account,
                          @Param("bank_code") int bank_code,
                          @Param("username") String username);


    /**
     * 根据删除银行账户
     *
     * @param id
     * @return 返回插入的数量
     */
    int deleteBankAccount(int id);

    /**
     * 根据用户id查询银行账户
     *
     * @param uid
     * @param offset 偏移量
     * @param limit  数量
     * @return
     */

    List<BankAccount> selectByUId(@Param("uid") String uid,
                                  @Param("offset") int offset,
                                  @Param("limit") int limit);


}