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

        Community community=new Community();
        community.setId(1);
        community.setAddress("wiyt");
        community.setName("chjv");
        communityDao.insertCommunity(community);

    }

    @Test
    public void deleteCommunity() throws Exception{




        communityDao.deleteCommunity(1);
    }


    @Test
    public void updateCollector() throws Exception{
        Community community=new Community();
        community.setId(2);

        community.setCid(2);
        communityDao.updateCollector(community);
    }

    @Test
    public void updateName() throws Exception{
        Community community=new Community();
        community.setId(2);

        community.setName("ciov");
        communityDao.updateCollector(community);
    }


    @Test
    public void selectByCid() throws Exception{

        List<Community> community= communityDao.selectByCid(1);
        for(Community community1:community)
        {
            System.out.println(community1);
        }
    }


    @Test
    public void selectByName() throws Exception{

        List<Community> community= communityDao.selectByName("v");
        for(Community community1:community)
        {
            System.out.println(community1);
        }
    }
}
