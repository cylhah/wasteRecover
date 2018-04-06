package org.cbb.wasteRecovery.daoTest;


import org.cbb.wasteRecovery.bean.ScrapMessage;
import org.cbb.wasteRecovery.dao.ScrapMessageDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(value =SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ScrapMessageDaoTest {


    @Resource
    private ScrapMessageDao scrapMessageDao;

    @Test
    public void insertScrapMessage() throws Exception {

       /* ScrapMessage scrapMessage=new ScrapMessage();
        scrapMessage.setPrice(3.5);
        scrapMessage.setWeight(10.2);
        scrapMessageDao.insertScrapMessage(scrapMessage);*/
    }

    @Test
    public void deleteScrapMessage() throws Exception{

       /* ScrapMessage scrapMessage=new ScrapMessage();
        scrapMessage.setOid(1);
        scrapMessage.setScrapid(1);
        scrapMessageDao.deleteScrapMessage(scrapMessage);*/
    }



}
