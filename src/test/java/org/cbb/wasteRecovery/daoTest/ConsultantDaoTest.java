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
        /**
         * Preparing: insert into consultant(staid,password,username) values (?,?,?)
         * Parameters: 2(Integer), root(String), 汪宏斌(String)
         * Updates: 1
         */
        int staid=2;
        String password="root";
        String username="汪宏斌";
        int i=consultantDao.insertConsultant(staid,username,password);
        System.out.println(i);

    }

    @Test
    public void deleteConsultant() throws Exception{
        /**
         * Preparing: delete from consultant where username=?
         * Parameters: 汪宏斌(String)
         *  Updates: 1
         */
        int i=consultantDao.deleteConsultant("汪宏斌");
        System.out.println(i);
    }

    @Test
    public void updateStaId() throws Exception{
        /**
         * Preparing: update consultant set staid=? where username=?
         * Parameters: 1(Integer), 汪宏斌(String)
         * Updates: 1
         */
        String username="汪宏斌";
        int staid=1;
        int i= consultantDao.updateStaId(username,staid);
        System.out.println(i);
    }


    @Test
    public void updatePassword() throws Exception{
        /**
         * Preparing: update consultant set password=? where username=?
         * Parameters: wang(String), 汪宏斌(String)
         * Updates: 1
         */
        String username="汪宏斌";
        String password="wang";
        int i= consultantDao.updatePassword(username,password);
        System.out.println(i);
    }

    @Test
    public void selectByUsername() throws Exception{
        String username="汪宏斌";
        Consultant consultant=consultantDao.selectByUsername(username);
        System.out.println(consultant);
    }


    @Test
    public void selectByUsernameAndPass() throws Exception{
        /**
         * Preparing: select t.staid,t.username, st.id sta_id, st.name sta_name, st.address sta_address, st.detailed_address sta_detailed_address
         * from consultant t INNER JOIN station st ON t.staid=st.id where t.username=? and t.password=?
         * Parameters: 汪宏斌(String), wang(String)
         *  Total: 1
         * Consultant{ staid=1, username='汪宏斌', password='null', station=Station{id=1, name='测试站', address='测试地址',
         * detailed_address='测试细节', locationX=0.0, locationY=0.0, collectorList=null, consultantList=null}}
         */
        String username="汪宏斌";
        String password="wang";
        Consultant consultant=consultantDao.selectByUsernameAndPass(username,password);
        System.out.println(consultant);
    }

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

}
