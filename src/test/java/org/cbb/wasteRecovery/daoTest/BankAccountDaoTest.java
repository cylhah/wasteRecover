package org.cbb.wasteRecovery.daoTest;

import org.cbb.wasteRecovery.bean.BankAccount;
import org.cbb.wasteRecovery.dao.BankAccountDao;
import org.cbb.wasteRecovery.entity.Page;
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
        /**
         *  Preparing: insert into bankaccount(uid,account,bank_code,username) values (?,?,?,?)
            Parameters: 123(String), erdf(String), 12534(Integer), 汪宏斌(String)
            Updates: 1
         */
        String uid="123";
        String account="erdf";
        int bank_code=12534;
        String username="汪宏斌";
        int i=bankAccountDao.insertBankAccount(uid,account,bank_code,username);
        System.out.println(i);

    }

    @Test
    public void deleteBankAccount() throws Exception{
        /**
         *  Preparing: delete from bankaccount where id=?
         *  Parameters: 3(Integer)
         *  Updates: 1
         */
        int i=bankAccountDao.deleteBankAccount(3);
        System.out.println(i);
    }

    @Test
    public void selectByUId() throws Exception{
        /**
         Preparing: select id,uid,account,bank_code,username from bankaccount where uid=? order BY id
         Parameters: 123(String)
         Total: 5
         BankAccount{id=2, uid='123', account='erdf', bank_code=12534, username='汪宏斌'}
         BankAccount{id=4, uid='123', account='erdf', bank_code=12534, username='汪宏斌'}
         BankAccount{id=5, uid='123', account='erdf', bank_code=12534, username='李白'}
         BankAccount{id=6, uid='123', account='erdf', bank_code=12534, username='李白'}
         BankAccount{id=10, uid='123', account='erdf', bank_code=12534, username='汪宏斌'}
         */
        String uid="123";
        List<BankAccount> bankAccount= bankAccountDao.selectByUId(uid);
        for(BankAccount bankAccount1:bankAccount)
        {
            System.out.println(bankAccount1);
        }
    }

}