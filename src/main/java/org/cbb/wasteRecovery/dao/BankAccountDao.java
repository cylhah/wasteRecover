package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.BankAccount;

import java.util.List;

public interface BankAccountDao {
    /**
     * 插入银行账户
     * @param uid
     * @param account
     * @param bank_code
     * @param username
     * @return 返回插入的数量
     */
    int insertBankAccount(String uid,String account,int bank_code,
                          String username);

    /**
     * 根据删除银行账户
     * @param id
     * @return 返回插入的数量
     */
    int deleteBankAccount(int id);

    /**
     * 根据用户id查询银行账户
     * @param uid
     * @param offset 偏移量
     * @param limit 数量
     * @return
     */
    List<BankAccount> selectByUId(String uid,int offset,int limit);
}
