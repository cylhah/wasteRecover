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
        /**
         * Preparing: insert ignore into scrapmessage(weight,price,oid,scrapid) values (?,?,?,?)
         * Parameters: 2.3(Double), 5.36(Double), 1(Long), 3(Integer)
         * Updates: 1
         */
        long oid=1;
        int scrapid=3;
        double weight=2.3;
        double price=5.36;
        int i=scrapMessageDao.insertScrapMessage(oid, scrapid, weight,price);
        System.out.println(i);
    }


    @Test
    public void deleteScrapMessage() throws Exception{
        /**
         * Preparing: delete from scrapmessage where oid=? and scrapid=?
         * Parameters: 1(Long), 3(Integer)
         * Updates: 1
         */

        long oid=1;
        int scrapid=3;

        int i= scrapMessageDao.deleteScrapMessage(oid, scrapid);
        System.out.println(i);
    }

    @Test
    public void updateData() throws Exception{

        /**
         * Preparing: update scrapmessage set weight = ? ,price = ? where scrapid = ? and oid= ?
         * Parameters: 4.5(Double), 0.3(Double), 3(Integer), 1(Long)
         * Updates: 1
         */
        long oid=1;
        int scrapid=3;
        double weight=4.5;
        double price=0.3;
        int i= scrapMessageDao.updateData(oid, scrapid, weight,price);
        System.out.println(i);
    }


}
