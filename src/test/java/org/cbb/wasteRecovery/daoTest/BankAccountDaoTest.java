package org.cbb.wasteRecovery.daoTest;

import org.cbb.wasteRecovery.bean.BankAccount;
import org.cbb.wasteRecovery.dao.BankAccountDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(value =SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:spring/spring-dao.xml")
public class BankAccountDaoTest {

    @Resource
    private BankAccountDao bankAccountDao;

    @Test
    public void insertBankAccount() throws Exception {

        String uid="qw";
        String account="erdf";
        int bank_code=12534;
        String username="zcvx";
        int i=bankAccountDao.insertBankAccount(uid,account,bank_code,username);
        System.out.println(i);

    }

    @Test
    public void deleteBankAccount() throws Exception{




        int i=bankAccountDao.deleteBankAccount(1);
        System.out.println(i);
    }

    @Test
    public void selectByUId() throws Exception{

        String uid="qw";
        int offset=1;
        int limit=1;
        List<BankAccount> bankAccount= bankAccountDao.selectByUId(uid,offset,limit);
        for(BankAccount bankAccount1:bankAccount)
        {
            System.out.println(bankAccount1);
        }
    }

}