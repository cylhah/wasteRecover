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
    public void insertCollector() throws Exception {
        Collector collector;
        collector = new Collector();
        collector.setAvater("pio");

        Timestamp ts=new Timestamp(new Date().getTime());
        collector.setCreateTime(ts);
        collector.setVolume(10);


        collector.setIdCardBackPhoto("杭州");
        collector.setIdCardFrontPhoto("浙江");

        collector.setIdCardNum("330283199710211418");
        collector.setRealName("江铮");
        collector.setSex('男');

        collector.setPhoto("cvdsp");
        collector.setState(5);
        collector.setPassword("rot");
        collector.setStatid(2);
        collector.setPhoneNumber("13867888450");
        int i=collectorDao.insertCollector(collector);
        System.out.println(i);
    }
    // 返回值为1

    @Test
    public void selectById() throws Exception{

     Collector collector=collectorDao.selectById(3);
        System.out.println(collector);
    }
    // 返回值为org.cbb.wasteRecovery.bean.Collector@dc9876b

    @Test
    public void selectByPhoneNum() throws Exception{

        Collector collector=collectorDao.selectByPhoneNum("13867888450");
        System.out.println(collector);

    }
    // 返回值为org.cbb.wasteRecovery.bean.Collector@dc9876b

    @Test
    public void selectByPhoneNumAndPass() throws Exception{

        String phoneNumber="13957863999";
        String password="qwer";
        Collector collector=collectorDao.selectByPhoneNumAndPass(phoneNumber,password);
        System.out.println(collector);
    }
    //返回值为org.cbb.wasteRecovery.bean.Collector@189cbd7c


    @Test
    public void selectByIdCardNum() throws Exception{

       Collector collector=collectorDao.selectByIdCardNum("330283199710211419");
        System.out.println(collector);
    }
    //返回值为org.cbb.wasteRecovery.bean.Collector@19976a65

    @Test
    public void selectByName() throws Exception{

        String name="黄书";
        int offset=0;
        int limit=1;
        List<Collector> collector= collectorDao.selectByName(name,offset,limit);
        for(Collector collector1:collector)
        {
            System.out.println(collector1);
        }
    }
    //返回值为org.cbb.wasteRecovery.bean.Collector@57a3e26a

    @Test
    public void updatePhoneNum() throws Exception{

        int id=1;
        String phoneNumber="13758149770";
        int i= collectorDao.updatePhoneNum(id,phoneNumber);
        System.out.println(i);
    }
    //返回值为1


    @Test
    public void updatePassword() throws Exception{

        int id=1;
        String password="root";
        int i= collectorDao.updatePassword(id,password);
        System.out.println(i);
    }
//返回值为1


    @Test
    public void addVolume() throws Exception{

        int id=1;

        int i= collectorDao.addVolume(id);
        System.out.println(i);
    }
    //返回值为1

    @Test
    public void updatePersonData() throws Exception{

        Collector collector=new Collector();
        collector.setId(1);
        collector.setRealName("黄书");
        collector.setSex('女');
        collector.setPhoneNumber("13957863999");
        collector.setPassword("qwer");
        collector.setAvater("ads");

        int i= collectorDao.updatePersonData(collector);
        System.out.println(i);
    }
    //返回值为1

    @Test
    public void updateState() throws Exception{

        int id=1;
        int state=10;
        int i= collectorDao.updateState(id,state);
        System.out.println(i);
    }
//返回值为1

    @Test
    public void deleteCollector() throws Exception{



        int id=2;
        int i= collectorDao.deleteCollector(id);
        System.out.println(i);
    }


    }




