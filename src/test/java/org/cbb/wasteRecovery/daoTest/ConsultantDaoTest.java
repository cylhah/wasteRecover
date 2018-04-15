package org.cbb.wasteRecovery.daoTest;


import org.cbb.wasteRecovery.bean.Consultant;
import org.cbb.wasteRecovery.dao.ConsultantDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(value =SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ConsultantDaoTest {

    @Resource
    private ConsultantDao consultantDao;

    @Test
    public void insertConsultant() throws Exception {

        int staid=2;
        String password="root";
        String username="汪宏斌";
        int i=consultantDao.insertConsultant(staid,username,password);
        System.out.println(i);

    }
    //返回值为1

    @Test
    public void deleteConsultant() throws Exception{




        int i=consultantDao.deleteConsultant(1);
        System.out.println(i);
    }
    //返回值为1

    @Test
    public void updateStaId() throws Exception{

        int id=1;
        int staid=3;
        int i= consultantDao.updateStaId(id,staid);
        System.out.println(i);
    }
    //返回值为0


    @Test
    public void updatePassword() throws Exception{

        int id=1;
        String password="wang";
        int i= consultantDao.updatePassword(id,password);
        System.out.println(i);
    }
    //返回值为0

    @Test
    public void selectByUsername() throws Exception{
        String username="汪宏斌";
        Consultant consultant=consultantDao.selectByUsername(username);
        System.out.println(consultant);
    }
    //返回值为org.cbb.wasteRecovery.bean.Consultant@3336e6b6


    @Test
    public void selectByUsernameAndPass() throws Exception{
        String username="汪宏斌";
        String password="root";
        Consultant consultant=consultantDao.selectByUsernameAndPass(username,password);
        System.out.println(consultant);
    }
    /*返回值为 org.cbb.wasteRecovery.bean.Consultant@22fa55b2

    Disconnected from the target VM, address: '127.0.0.1:60472', transport: 'socket'*/

    @Test
    public void selectByStaId() throws Exception{

        int staid=2;
        int offset=0;
        int limit=1;
        List<Consultant> Consultant= consultantDao.selectByStaId(staid,offset,limit);
        for(Consultant Consultant1:Consultant)
        {
            System.out.println(Consultant1);
        }
    }
    //返回值为org.cbb.wasteRecovery.bean.Consultant@4b2c5e02


}
