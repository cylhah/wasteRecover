package org.cbb.wasteRecovery.daoTest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.OrderformDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.cbb.wasteRecovery.bean.*;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class OrderformDaoTest {

    @Resource
    private OrderformDao orderformDao;

    @Test
    public void insertOrderform() throws Exception{
        Timestamp createTime=new Timestamp(new Date().getTime());

        Timestamp appointTime=new Timestamp(new Date().getTime());
        int aid=1001;
        String uid="123";
        int state=1;

        int i=orderformDao.insertOrderform(createTime,appointTime, aid, uid, state);
        System.out.println(i);
    }
    //返回值为1


    @Test
    public void selectById() throws Exception{

        Orderform orderform=orderformDao.selectById(2);
        System.out.println(orderform);
        /**
         * 2018-04-10 18:28:14,031 [main] DEBUG [org.cbb.wasteRecovery.dao.OrderformDao.selectById] - ==>
         * Preparing: select c.realName,c.sex,c.password,c.phoneNumber,c.photo,c.idCardNum,c.idCardFrontPhoto,c.idCardBackPhoto,
         * c.createTime,c.avater,c.staid,c.state,c.volume,
         * o.id,o.state,o.weight,o.createTime,o.appointTime,o.updateTime,o.price,o.aid,o.uid,o.cid,
         * a.id,a.uid,a.address,a.detail,a.community_id,a.geohash,a.position,
         * u.state,u.avater,u.openid, sc.weight,sc.price,sc.oid,sc.scrapid
         * from (((orderform o INNER JOIN user u ON o.uid=u.openid)LEFT JOIN
         * collector c ON o.cid=c.id) LEFT JOIN scrapmessage sc ON o.id=sc.oid)INNER JOIN useraddress a ON o.aid=a.id where o.id=?
         *
         * 2018-04-10 18:28:14,066 [main] DEBUG [org.cbb.wasteRecovery.dao.OrderformDao.selectById] - ==> Parameters: 2(Long)
         * 2018-04-10 18:28:14,092 [main] DEBUG [org.cbb.wasteRecovery.dao.OrderformDao.selectById] - <==      Total: 1
         * Orderform{id=2, uid='123', cid=0, aid=1004, state=0, weight=0.0, createTime=null, appointTime=null, updateTime=null,
         * price=0.0, user=User{openid='123', avater='null', state=0, addressList=null, accountList=null},
         * collector=Collector{id=2, realName='null', sex= , avater='null', phoneNumber='null', password='null',
         * photo='null', idCardNum='null', idCardFrontPhoto='null', idCardBackPhoto='null', volume=0, createTime=null,
         * state=0, staid=0, station=null, unDidOrderformList=null, DidOrderformList=null, communityList=null},
         * address=UserAddress{id=2, uid='123', address='浙江科技学院小和山', detail='null', phoneNumber='null',
         * name='null', community_id=0, community=null, locationX=0.0, locationY=0.0, geohash='0100010', user=null}, scrapMessageList=[]}
         */
    }


    @Test
    public void selectByCId() throws Exception{

        int cid=3;
        int state=1;
        int offset=0;
        int limit=1;
        List<Orderform> Orderform= orderformDao.selectByCId(cid,state,offset,limit);
        for(Orderform Orderform1:Orderform)
        {
            System.out.println(Orderform1);
        }
    }
    //返回值为org.cbb.wasteRecovery.bean.Orderform@6c2f1700


    @Test
    public void selectByUId() throws Exception{

        String uid="qwerd";
        int state=1;
        int offset=0;
        int limit=1;
        List<Orderform> Orderform= orderformDao.selectByUId(uid,state,offset,limit);
        for(Orderform Orderform1:Orderform)
        {
            System.out.println(Orderform1);
        }
    }
    //返回值为org.cbb.wasteRecovery.bean.Orderform@680bddf5





    @Test
    public void selectByState() throws Exception{
        int state=1;
        int offset=0;
        int limit=1;
        List<Orderform> Orderform= orderformDao.selectByState(state,offset,limit);
        for(Orderform Orderform1:Orderform)
        {
            System.out.println(Orderform1);
        }
    }



    @Test
    public void selectByPos() throws Exception{
        /**
         * Preparing: select x(ua.position) "address.locationX",y(ua.position) "address.locationY"
         * from orderform o INNER JOIN useraddress ua ON o.aid = ua.id where
         * ua.geohash LIKE ? '%' AND st_distance_sphere(point(?,?),ua.position) <= ? AND o.uid!=?
         *  Parameters: 01(String), 1.2(Double), 2.1(Double), 6.0E7(Double), 120(String)
         *  Orderform{..address=UserAddress{..locationX=108.9498710632, locationY=34.2588125935..}..}
         *  Orderform{..address=UserAddress{..locationX=108.9465236664, locationY=34.2598766768..}..}
         */

        double locationX=1.2;
        double locationY=2.1;
        String geohash="01";
        double distance=60000000;
        List<Orderform> Orderform= orderformDao.selectByPos("120",geohash,locationX,locationY,distance);
        for(Orderform Orderform1:Orderform)
        {
            System.out.println(Orderform1);
        }
    }




    @Test
    public void updateOrderform() throws Exception{

        Timestamp appointTime=new Timestamp(new Date().getTime());
        int aid=2;
        long id=1;
        int i=orderformDao.updateOrderform(id,aid,appointTime);
        System.out.println(i);
    }
    //返回值为1

    @Test
    public void submitData() throws Exception{

        Orderform orderform=new Orderform();
        orderform.setPrice(5.31);
        orderform.setState(1);
        orderform.setAid(2);
        orderform.setUid("qwerd");
        orderform.setCid(3);
        orderform.setWeight(61.23);
        orderform.setId(1);
        int i=orderformDao.submitData(orderform);
        System.out.println(i);
    }
    //返回值为1

    @Test
    public void deleteOrderform() throws Exception{

        int i=orderformDao.deleteOrderform(2);
        System.out.println(i);
    }
    //返回值为1

}
