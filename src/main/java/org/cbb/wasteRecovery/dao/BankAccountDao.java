package org.cbb.wasteRecovery.dao;

import org.cbb.wasteRecovery.bean.BankAccount;

public interface BankAccountDao {
    /**
     * 插入银行账户
     * @param bankAccount 存有uid,account,bank_code,username
     */
    void insertBankAccount(BankAccount bankAccount);

    /**
     * 根据删除银行账户
     * @param id
     */
    void deleteBankAccount(int id);
}
