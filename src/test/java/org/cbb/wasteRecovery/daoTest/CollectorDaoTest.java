package org.cbb.wasteRecovery.daoTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.CollectorDao;
import org.cbb.wasteRecovery.entity.Page;
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
        collector.setStaid(2);
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
        String phoneNumber="13867888451";
        String password="qqwasdzxc";
        Collector collector=collectorDao.selectByPhoneNumAndPass(phoneNumber,password);
        System.out.println(collector);
    }
    //返回值为org.cbb.wasteRecovery.bean.Collector@189cbd7c


    @Test
    public void filterCollPage() throws Exception{
        /**
         * 2018-04-13 14:09:55,271 [main] DEBUG [org.cbb.wasteRecovery.dao.CollectorDao.filterCollPage] - ==>  Preparing: select count(*) from (select c.id,c.realName,c.sex,c.phoneNumber,c.photo,c.idCardNum,c.idCardFrontPhoto,c.idCardBackPhoto,c.createTime,c.avater,c.state,c.volume, sta.id sta_id, sta.detailed_address sta_detailed_address, sta.name sta_name, sta.address sta_address, comm.id comm_id, comm.address comm_address, comm.name comm_name from (collector c INNER JOIN station sta ON sta.id=c.staid)LEFT JOIN community comm on c.id = comm.cid WHERE c.realName = ? order BY c.id)a
         * 2018-04-13 14:09:55,305 [main] DEBUG [org.cbb.wasteRecovery.dao.CollectorDao.filterCollPage] - ==> Parameters: 江铮(String)
         * 2018-04-13 14:09:55,401 [main] DEBUG [org.cbb.wasteRecovery.dao.CollectorDao.filterCollPage] - ==>  Preparing: select c.id,c.realName,c.sex,c.phoneNumber,c.photo,c.idCardNum,c.idCardFrontPhoto,c.idCardBackPhoto,c.createTime,c.avater,c.state,c.volume, sta.id sta_id, sta.detailed_address sta_detailed_address, sta.name sta_name, sta.address sta_address, comm.id comm_id, comm.address comm_address, comm.name comm_name from (collector c INNER JOIN station sta ON sta.id=c.staid)LEFT JOIN community comm on c.id = comm.cid WHERE c.realName = ? order BY c.id limit 0,5
         * 2018-04-13 14:09:55,402 [main] DEBUG [org.cbb.wasteRecovery.dao.CollectorDao.filterCollPage] - ==> Parameters: 江铮(String)
         * 2018-04-13 14:09:55,449 [main] DEBUG [org.cbb.wasteRecovery.dao.CollectorDao.filterCollPage] - <==      Total: 2
         * Collector{id=1, realName='江铮', sex=男, avater='/testAvater.jpg', phoneNumber='13867888450', password='null', photo='/testphoto.jpg', idCardNum='330283199710211418', idCardFrontPhoto='/testfront.jpg', idCardBackPhoto='/testback.jpg', volume=0, createTime=2018-04-12 16:58:04.0, state=1, staid=0, station=Station{id=2, name='更改测试', address='更改地址', detailed_address='更改细节', locationX=0.0, locationY=0.0, collectorList=null, consultantList=null}, communityList=[Community{id=1, address='中国', cid=0, name='汪宏斌小区', collector=null}]}
         * Collector{id=6, realName='江铮', sex=男, avater='/testAvater.jpg', phoneNumber='13867888452', password='null', photo='/testphoto.jpg', idCardNum='330283199710211416', idCardFrontPhoto='/testfront.jpg', idCardBackPhoto='/testback.jpg', volume=0, createTime=2018-04-12 16:45:21.0, state=1, staid=0, station=Station{id=2, name='更改测试', address='更改地址', detailed_address='更改细节', locationX=0.0, locationY=0.0, collectorList=null, consultantList=null}, communityList=[]}
         */
        Map constrains=new HashMap();
        constrains.put("c.realName","江铮");
        Page page=new Page(5);
        List<Collector> collectorList=collectorDao.filterCollPage(constrains,page);
        for (Collector collector :
                collectorList) {
            System.out.println(collector);
        }
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
    public void updateData() throws Exception{
        /**
         * Preparing: update collector set openid=? where id = ?
         * Parameters: 123(String), 1(Integer)
         * Updates: 1
         */
        int id=1;
        Map constrains=new HashMap();
        constrains.put("phoneNumber","13867888451");
        int i= collectorDao.updateData(id,constrains);
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




