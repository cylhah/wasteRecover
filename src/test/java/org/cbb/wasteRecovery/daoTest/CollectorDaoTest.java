package org.cbb.wasteRecovery.daoTest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.CollectorDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cbb.wasteRecovery.bean.*;


@RunWith(value =SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class CollectorDaoTest {
    @Resource
    private CollectorDao collectorDao;

    @Test
    public void InsertCollector() throws Exception {
        /*Collector collector;
        collector = new Collector();

        collector.setPhoneNumber("13957863999");
        collectorDao.InsertCollector(collector);*/
    }

    @Test
    public void selectById() throws Exception{

     /*   Collector collector=collectorDao.selectById(1);
        System.out.println(collector);*/
    }
    @Test
    public void selectByPhoneNum() throws Exception{

       /* Collector collector=collectorDao.selectByPhoneNum("13758149770");
        System.out.println(collector);*/

    }

    @Test
    public void selectByPhoneNumAndPass() throws Exception{
      /*  Collector collector1=new Collector();
        collector1.setPhoneNumber("13758149770");
        collector1.setPassword("root");
        Collector collector=collectorDao.selectByPhoneNumAndPass(collector1);
        System.out.println(collector);*/
    }

    @Test
    public void selectByIdCardNum() throws Exception{

       /* Collector collector=collectorDao.selectByIdCardNum("330283199710211419");
        System.out.println(collector);*/
    }


    }




