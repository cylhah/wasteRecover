package org.cbb.wasteRecovery.daoTest;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.cbb.wasteRecovery.dao.OrderformDao;
import org.cbb.wasteRecovery.entity.Page;
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
        /**
         *  Preparing: insert into orderform(appointTime,aid,uid) values (?,?,?)
         *  Parameters: 2018-04-12 19:40:57.851(Timestamp), 2(Integer), 1001(String)
         *  Updates: 1
         */

        Timestamp appointTime=new Timestamp(new Date().getTime());
        int aid=2;
        String uid="1001";

        int i=orderformDao.insertOrderform(appointTime, aid, uid);
        System.out.println(i);
    }


    @Test
    public void selectById() throws Exception{
        /**
         * Preparing: select o.id,o.state,o.weight,o.createTime,o.appointTime,o.updateTime,o.price, c.id col_id, c.realName col_realName, c.sex col_sex, c.phoneNumber col_phoneNumber, c.idCardNum col_idCardNum, c.createTime col_createTime, c.avater col_avater, c.state col_state, c.volume col_volume, a.id ua_id, a.address ua_address, u.avater u_avater, u.openid u_openid, sm.weight sm_weight, sm.price sm_price, scr.id scr_id, scr.name scr_name from ( ( ( orderform o INNER JOIN user u ON o.uid=u.openid ) LEFT JOIN collector c ON o.cid=c.id ) LEFT JOIN (scrapmessage sm INNER JOIN scrap scr ON scr.id=sm.scrapid) ON o.id=sm.oid ) INNER JOIN useraddress a ON o.aid=a.id where o.id=?
         * Parameters: 1(Long)
         * otal: 1
         * Orderform{id=1, uid='null', cid=0, aid=0, state=1, weight=0.0,
         * createTime=2018-04-12 19:40:58.0, appointTime=2018-04-12 19:40:57.0, updateTime=2018-04-12 19:40:58.0, price=0.0,
         * user=User{openid='1001', avater='user/document/test.jpg', state=0, addressList=null, accountList=null}, collector=null,
         * address=UserAddress{id=2, uid='null', address='杭州', detail='null', phoneNumber='null', name='null', community_id=0,
         * community=null, locationX=0.0, locationY=0.0, geohash='null', user=null}, scrapMessageList=[]}
         */

        Orderform orderform=orderformDao.selectById(1);
        System.out.println(orderform);
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
        /**
         * Preparing: update orderform set state=? where id = ?
         * Parameters: 2(Integer), 1(Long)
         * Updates: 1
         */

        long id=1;
        int i=orderformDao.updateOrderform(id,2);
        System.out.println(i);
    }

    @Test
    public void submitData() throws Exception{
        /**
         * Preparing: update orderform set cid = ?, price = ?, state = ?, weight = ? where id = ?
         * Parameters: 1(Integer), 5.31(Double), 2(Integer), 61.23(Double), 2(Long)
         * Updates: 1
         */

        Orderform orderform=new Orderform();
        orderform.setPrice(5.31);
        orderform.setState(2);
        orderform.setCid(1);
        orderform.setWeight(61.23);
        orderform.setId(2);
        int i=orderformDao.submitData(orderform);
        System.out.println(i);
    }

    @Test
    public void deleteOrderform() throws Exception{
        /**
         * Preparing: delete from orderform where id=?
         * Parameters: 3(Long)
         * Updates: 1
         */

        int i=orderformDao.deleteOrderform(3);
        System.out.println(i);
    }

    @Test
    public void filterOrderPage() throws Exception{
        /**
         *  Preparing: select count(*) from (select o.id,o.state,o.updateTime,o.price, c.id col_id, c.realName col_realName, a.id ua_id, a.address ua_address, a.name ua_name, u.openid u_openid, sm.weight sm_weight, scr.name scr_name from ( ( ( orderform o INNER JOIN user u ON o.uid=u.openid ) LEFT JOIN collector c ON o.cid=c.id ) LEFT JOIN (scrapmessage sm INNER JOIN scrap scr ON scr.id=sm.scrapid) ON o.id=sm.oid ) INNER JOIN useraddress a ON o.aid=a.id WHERE o.updateTime Like ? '%' AND o.state = ?)a
         *  Parameters: 2018-04-12(String), 2(Integer)
         *  Preparing: select o.id,o.state,o.updateTime,o.price, c.id col_id, c.realName col_realName, a.id ua_id, a.address ua_address, a.name ua_name, u.openid u_openid, sm.weight sm_weight, scr.name scr_name from ( ( ( orderform o INNER JOIN user u ON o.uid=u.openid ) LEFT JOIN collector c ON o.cid=c.id ) LEFT JOIN (scrapmessage sm INNER JOIN scrap scr ON scr.id=sm.scrapid) ON o.id=sm.oid ) INNER JOIN useraddress a ON o.aid=a.id WHERE o.updateTime Like ? '%' AND o.state = ? limit 0,5
         *  Parameters: 2018-04-12(String), 2(Integer)
         *  Total: 2
         *
         * Orderform{id=1, uid='null', cid=0, aid=0, state=2, weight=0.0, createTime=null,
         * appointTime=null, updateTime=2018-04-12 20:09:08.0, price=0.0,
         * user=User{openid='1001', avater='null', state=0, addressList=null, accountList=null},
         * collector=null, address=UserAddress{id=2, uid='null', address='杭州', detail='null', phoneNumber='null', name='李白',
         * community_id=0, community=null, locationX=0.0, locationY=0.0, geohash='null', user=null},
         * scrapMessageList=[ScrapMessage{oid=0, scrapid=0, weight=4.5, price=0.0, scrap=Scrap{id=0, typeName='null',
         * name='钢化玻璃', unitPrice=0.0, monthVolume=0.0, totalVolume=0.0}, orderform=null}]}
         *
         * Orderform{id=2, uid='null', cid=0, aid=0, state=2, weight=0.0, createTime=null, appointTime=null,
         * updateTime=2018-04-12 20:12:29.0, price=5.31,
         * user=User{openid='1001', avater='null', state=0, addressList=null, accountList=null},
         * collector=Collector{id=1, realName='江铮', sex=null, avater='null', phoneNumber='null', password='null', photo='null',
         * idCardNum='null', idCardFrontPhoto='null', idCardBackPhoto='null', volume=0, createTime=null, state=0, staid=0,
         * station=null, communityList=null},
         * address=UserAddress{id=2, uid='null', address='杭州', detail='null', phoneNumber='null', name='李白',
         * community_id=0, community=null, locationX=0.0, locationY=0.0, geohash='null', user=null}, scrapMessageList=[]}
         */

        Map constrains=new HashMap();
        constrains.put("o.updateTime","2018-04-12");
        constrains.put("o.state",2);
        Page page=new Page(5);
        page.setCurrentPageNum(1);

        List<Orderform> orderformList=orderformDao.filterOrderPage(constrains,page);
        for (Orderform orderform :orderformList) {
            System.out.println(orderform);
        }
    }

}
