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

        long oid=1;
        int scrapid=3;
        double weight=2.3;
        double price=5.36;
        int i=scrapMessageDao.insertScrapMessage(oid, scrapid, weight,price);
        System.out.println(i);
    }
//返回值为1


    @Test
    public void deleteScrapMessage() throws Exception{

        long oid=1;
        int scrapid=3;

        int i= scrapMessageDao.deleteScrapMessage(oid, scrapid);
        System.out.println(i);
    }
//返回值为1

    @Test
    public void updateData() throws Exception{

        long oid=1;
        int scrapid=3;
        double weight=4.5;
        double price=52.36;
        int i= scrapMessageDao.updateData(oid, scrapid, weight,price);
        System.out.println(i);
    }
//返回值为1

    @Test
    public void selectByOId() throws Exception{

        long oid=1;
        int offset=0;
        int limit=1;
        List<ScrapMessage> ScrapMessage=scrapMessageDao.selectByOId(oid,offset,limit);
        for(ScrapMessage ScrapMessage1:ScrapMessage)
        {
            System.out.println(ScrapMessage1);
        }
    }
    //返回值为org.cbb.wasteRecovery.bean.ScrapMessage@75c56eb9


    @Test
    public void selectByScId() throws Exception{

        int scrapId=3;
        int offset=0;
        int limit=1;
        List<ScrapMessage> ScrapMessage=scrapMessageDao.selectByScId(scrapId,offset,limit);
        for(ScrapMessage ScrapMessage1:ScrapMessage)
        {
            System.out.println(ScrapMessage1);
        }
    }
//返回值为org.cbb.wasteRecovery.bean.ScrapMessage@75c56eb9

}
