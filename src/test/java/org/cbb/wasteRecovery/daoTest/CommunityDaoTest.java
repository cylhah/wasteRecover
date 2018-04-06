package org.cbb.wasteRecovery.daoTest;


import org.cbb.wasteRecovery.bean.Community;
import org.cbb.wasteRecovery.dao.CommunityDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(value =SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:spring/spring-dao.xml")
public class CommunityDaoTest {

    @Resource
    private CommunityDao communityDao;

    @Test
    public void insertCommunity() throws Exception {


        String address="杭州";
        String name="周鹏";
       int i=communityDao.insertCommunity(address,name);
        System.out.println(i);

    }
    //返回值是1

    @Test
    public void deleteCommunity() throws Exception{




        int i=communityDao.deleteCommunity(2);
        System.out.println(i);
    }
    //返回值是1

    @Test
    public void updateCollectorOfComm() throws Exception{

        int id=1;
        int cid=3;
        int i=communityDao.updateCollectorOfComm(id,cid);
        System.out.println(i);
    }
    //返回值是1

    @Test
    public void updateData() throws Exception{

        String name="汪宏斌";
        String address="中国";



        int i=communityDao.updateData(name,address);
        System.out.println(i);
    }
    //返回值是1


    @Test
    public void selectByCid() throws Exception{

        int cid=3;
        int offset=1;
        int limit=1;
       List<Community> community= communityDao.selectByCid(cid,offset,limit);
        for(Community community1:community)
        {
            System.out.println(community1);
        }
    }
    //返回值是org.cbb.wasteRecovery.bean.Community@4b2c5e02


    @Test
    public void selectByName() throws Exception{

        String name="汪";
        int offset=0;
        int limit=1;
        List<Community> community= communityDao.selectByName(name,offset,limit);
        for(Community community1:community)
        {
            System.out.println(community1);
        }
    }
    //返回值是org.cbb.wasteRecovery.bean.Community@19976a65
}
