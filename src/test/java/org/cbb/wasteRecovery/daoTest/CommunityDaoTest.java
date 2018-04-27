package org.cbb.wasteRecovery.daoTest;


import org.cbb.wasteRecovery.bean.Community;
import org.cbb.wasteRecovery.bean.UserAddress;
import org.cbb.wasteRecovery.dao.CommunityDao;
import org.cbb.wasteRecovery.entity.MatchCommunity;
import org.cbb.wasteRecovery.entity.Page;
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
        /**
         * Preparing: insert into community(address,name) values (?,?)
         * Parameters: 奉化(String), 不会饿小区(String)
         * Updates: 1
         */

        String address="奉化";
        String name="不会饿小区";
       int i=communityDao.insertCommunity(address,name);
        System.out.println(i);

    }

    @Test
    public void deleteCommunity() throws Exception{
        /**
         * Preparing: delete from community where id=?
         * Parameters: 2(Integer)
         * Updates: 1
         */

        int i=communityDao.deleteCommunity(2);
        System.out.println(i);
    }

    @Test
    public void updateCollectorOfComm() throws Exception{
        /**
         * Preparing: update community set cid = ? where id = ?
         * Parameters: 1(Integer), 1(Integer)
         * Updates: 1
         */
        int id=1;
        int cid=1;
        int i=communityDao.updateCollectorOfComm(id,cid);
        System.out.println(i);
    }

    @Test
    public void updateData() throws Exception{
        /**
         * Preparing: update community set address=? ,name = ? where id=?
         * Parameters: 中国(String), 汪宏斌小区(String), 1(Integer)
         * Updates: 1
         */

        String name="汪宏斌小区";
        String address="中国";

        int i=communityDao.updateData(1,name,address);
        System.out.println(i);
    }


    @Test
    public void selectByCid() throws Exception{

        int cid=3;
        int offset=1;
        int limit=1;
       List<Community> community= communityDao.selectByCid(cid,new Page());
        for(Community community1:community)
        {
            System.out.println(community1);
        }
    }


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

    @Test
    public void selectByAddress() throws Exception{
        String address="奉";
        List<Community> communityList=communityDao.selectByAddress(address);
        for(Community community:communityList){
            System.out.println(community);
        }
    }
}
