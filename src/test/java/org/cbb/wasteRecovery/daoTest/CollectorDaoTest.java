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
        Collector collector;
        collector = new Collector();
        collector.setAvater("po");
        collector.setBankAccount("0205");
        Timestamp ts=new Timestamp(new Date().getTime());
        collector.setCreateTime(ts);
        collector.setVolume(5);
        collector.setEmail("1004758012@qq.com");

        collector.setIdCardBackPhoto("宁波");
        collector.setIdCardFrontPhoto("浙江");

        collector.setIdCardNum("330283199710211419");
        collector.setName("汪宏斌");
        collector.setSex('男');
        collector.setCreditValue(3.46);
        collector.setPhoto("cvp");
        collector.setState(6);
        collector.setPassword("roott");
        collector.setPhoneNumber("13957863999");
        collectorDao.InsertCollector(collector);
    }

    @Test
    public void selectById() throws Exception{

        Collector collector=collectorDao.selectById(1);
        System.out.println(collector);
    }
    @Test
    public void selectByPhoneNum() throws Exception{

        Collector collector=collectorDao.selectByPhoneNum("13758149770");
        System.out.println(collector);

    }

    @Test
    public void selectByPhoneNumAndPass() throws Exception{
        Collector collector1=new Collector();
        collector1.setPhoneNumber("13758149770");
        collector1.setPassword("root");
        Collector collector=collectorDao.selectByPhoneNumAndPass(collector1);
        System.out.println(collector);
    }

    @Test
    public void selectByIdCardNum() throws Exception{

        Collector collector=collectorDao.selectByIdCardNum("330283199710211419");
        System.out.println(collector);
    }

    @Test
    public void selectByName() throws Exception{


        List<Collector> collector=collectorDao.selectByName("汪宏斌");

        for(Collector collector1:collector)
        {
            System.out.println(collector1);
        }

    }

    @Test
    public void selectByState() throws Exception{


        List<Collector> collector=collectorDao.selectByState(5);

        for(Collector collector1:collector)
        {
            System.out.println(collector1);
        }

    }

    @Test
    public void updatePhoneNum() throws Exception{
        Collector collector1=new Collector();

        collector1.setPhoneNumber("18857475223");
        collector1.setId(1);
        collectorDao.updatePhoneNum(collector1);
    }

    @Test
    public void updatePassword() throws Exception{
        Collector collector1=new Collector();

        collector1.setPassword("zx");
        collector1.setId(1);
        collectorDao.updatePassword(collector1);
    }

    @Test
    public void updateCreditValue() throws Exception{
        Collector collector1=new Collector();

        collector1.setCreditValue(3.56);
        collector1.setId(2);
        collectorDao.updateCreditValue(collector1);
    }

    @Test
    public void updateAccount() throws Exception{
        Collector collector1=new Collector();

        collector1.setBankAccount("1024");
        collector1.setId(2);
        collectorDao.updateAccount(collector1);
    }

    @Test
    public void addVolume() throws Exception{
        Collector collector1=new Collector();

        collector1.setVolume(9);
        collector1.setId(2);
        collectorDao.addVolume(collector1);
    }

    @Test
    public void updatePersonData() throws Exception{
        Collector collector1=new Collector();
        collector1.setEmail("10058012@qq.com");
        collector1.setPhoneNumber("18857475223");
        collector1.setAvater("mn");
        collector1.setPassword("yu");
        collector1.setBankAccount("1025");
        collector1.setName("江铮");
        collector1.setSex('男');
        collector1.setId(3);
        collectorDao.updatePersonData(collector1);
    }
}
