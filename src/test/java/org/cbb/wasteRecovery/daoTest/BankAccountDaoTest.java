package org.cbb.wasteRecovery.daoTest;

import org.cbb.wasteRecovery.bean.BankAccount;
import org.cbb.wasteRecovery.dao.BankAccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(value =SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:spring/spring-dao.xml")
public class BankAccountDaoTest {

    @Resource
    private BankAccountDao bankAccountDao;

    @Test
    public void insertBankAccount() throws Exception {

        BankAccount bankAccount;
        bankAccount=new BankAccount();
        bankAccount.setId(2);
        bankAccount.setAccount("qwer");
        bankAccount.setBank_code(1234586);
        bankAccount.setUsername("asdf");
        bankAccountDao.insertBankAccount(bankAccount);

    }

    @Test
    public void deleteBankAccount() throws Exception{




        bankAccountDao.deleteBankAccount(1);
    }

}