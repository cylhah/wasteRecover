package org.cbb.wasteRecovery.daoTest;
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
        /**
         * Preparing: insert into collector
         * (realName,sex,password,phoneNumber,photo,idCardNum,idCardFrontPhoto,idCardBackPhoto,avater,staid)
         * values (?,?,?,?,?,?,?,?,?,?)
         * Parameters: 江铮(String), 男(String), qqwasdzxc(String), 13867888450(String), /testphoto.jpg(String),
         * 330283199710211418(String), /testfront.jpg(String), /testback.jpg(String), /testAvater.jpg(String), 2(Integer)
         * Updates: 1
         */
        Collector collector;
        collector = new Collector();
        collector.setAvater("/testAvater.jpg");


        collector.setIdCardBackPhoto("/testback.jpg");
        collector.setIdCardFrontPhoto("/testfront.jpg");

        collector.setIdCardNum("330283199710211418");
        collector.setRealName("江铮");
        collector.setSex("男");

        collector.setPhoto("/testphoto.jpg");
        collector.setPassword("qqwasdzxc");
        collector.setStatid(2);
        collector.setPhoneNumber("13867888450");
        int i=collectorDao.insertCollector(collector);
        System.out.println(i);
    }

    @Test
    public void selectById() throws Exception{

        Collector collector=collectorDao.selectById(3);
        System.out.println(collector);
    }

    @Test
    public void selectByPhoneNum() throws Exception{

        Collector collector=collectorDao.selectByPhoneNum("13867888450");
        System.out.println(collector);

    }
    // 返回值为org.cbb.wasteRecovery.bean.Collector@dc9876b

    @Test
    public void selectByPhoneNumAndPass() throws Exception{
        /**
         *Preparing: select c.id,c.realName,c.sex,c.phoneNumber,c.photo,c.idCardNum,c.idCardFrontPhoto,c.idCardBackPhoto,c.createTime,c.avater,c.state,c.volume, sta.id sta_id, sta.detailed_address sta_detailed_address, sta.name sta_name, sta.address sta_address, comm.id comm_id, comm.address comm_address, comm.name comm_name from (collector c INNER JOIN station sta ON sta.id=c.staid)LEFT JOIN community comm on c.id = comm.cid where c.phoneNumber=? and c.password=?
         *Parameters: 13867888450(String), qqwasdzxc(String)
         *Total: 1
         *Collector{id=1, realName='江铮', sex=男, avater='/testAvater.jpg', phoneNumber='13867888450', password='null',
         * photo='/testphoto.jpg', idCardNum='330283199710211418', idCardFrontPhoto='/testfront.jpg', idCardBackPhoto='/testback.jpg',
         * volume=0, createTime=2018-04-12 15:55:31.0, state=1, staid=0,
         * station=Station{id=2, name='更改测试', address='更改地址', detailed_address='更改细节',
         * locationX=0.0, locationY=0.0, collectorList=null, consultantList=null},
         * communityList=[]}
         */
        String phoneNumber="13867888450";
        String password="qqwasdzxc";
        Collector collector=collectorDao.selectByPhoneNumAndPass(phoneNumber,password);
        System.out.println(collector);
    }
    //返回值为org.cbb.wasteRecovery.bean.Collector@189cbd7c


    @Test
    public void selectByIdCardNum() throws Exception{

       Collector collector=collectorDao.selectByIdCardNum("330283199710211419");
        System.out.println(collector);
    }

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

    @Test
    public void updatePhoneNum() throws Exception{
        /**
         * Preparing: update collector set phoneNumber = ? where id = ?
         * Parameters: 13867888452(String), 6(Integer)
         * Updates: 1
         */

        int id=6;
        String phoneNumber="13867888452";
        int i= collectorDao.updatePhoneNum(id,phoneNumber);
        System.out.println(i);
    }


    @Test
    public void updatePassword() throws Exception{
        /**
         * Preparing: update collector set password = ? where id = ?
         * Parameters: root(String), 1(Integer)
         * Updates: 1
         */

        int id=1;
        String password="root";
        int i= collectorDao.updatePassword(id,password);
        System.out.println(i);
    }



    @Test
    public void updatePersonData() throws Exception{
        /**
         * Preparing: update collector set phoneNumber = ?, password = ?, realName=?, sex=?, avater=? where id = ?
         * Parameters: 13957863999(String), qweasd(String), 老铁(String), 女(String), /testupdate.jpg(String), 1(Integer)
         * Updates: 1
         */

        Collector collector=new Collector();
        collector.setId(1);
        collector.setRealName("老铁");
        collector.setSex("女");
        collector.setPhoneNumber("13957863999");
        collector.setPassword("qweasd");
        collector.setAvater("/testupdate.jpg");

        int i= collectorDao.updatePersonData(collector);
        System.out.println(i);
    }

    @Test
    public void updateState() throws Exception{
        /**
         * Preparing: update collector set state = ? where id = ?
         * Parameters: 0(Integer), 1(Integer)
         * Updates: 1
         */

        int id=1;
        int state=0;
        int i= collectorDao.updateState(id,state);
        System.out.println(i);
    }

    @Test
    public void deleteCollector() throws Exception{
        /**
         * Preparing: delete from collector where id=?
         * Parameters: 1(Integer)
         * Updates: 1
         */

        int id=1;
        int i= collectorDao.deleteCollector(id);
        System.out.println(i);
    }


    }




