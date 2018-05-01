package org.cbb.wasteRecovery.service;

import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.bean.Scrap;
import org.cbb.wasteRecovery.bean.UserAddress;
import org.cbb.wasteRecovery.entity.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
    "classpath:spring/spring-service.xml"})
public class SelectServiceTest {

    @Autowired
    SelectService selectService;

    @Test
    public void selectOrdersByPos() {
        /**
         * Preparing: select x(ua.position) "address.locationX",y(ua.position) "address.locationY" from orderform o INNER JOIN useraddress ua ON o.aid = ua.id where ua.geohash LIKE ? '%' AND st_distance_sphere(point(?,?),ua.position) <= ? AND o.uid!=?
         * ypbp(String), 90.0(Double), 90.0(Double), 5000.0(Double), 1001(String)
         * Total: 1
         */
        UserAddress userAddress=new UserAddress();
        userAddress.setLocationX(90);
        userAddress.setLocationY(90);
        userAddress.setUid("1001");
        System.out.println(selectService.selectOrdersByPos(userAddress));
    }

    @Test
    public void selectOrdersByUid() {
        /**
         * Preparing: select count(*) from (
         * select o.id,o.state,o.updateTime,o.price, c.id col_id, c.realName col_realName,
         * a.id ua_id, a.address ua_address, a.name ua_name,
         * u.openid u_openid,
         * sm.weight sm_weight, scr.name scr_name from (
         * ( ( orderform o INNER JOIN user u ON o.uid=u.openid ) LEFT JOIN collector c ON o.cid=c.id )
         * LEFT JOIN (scrapmessage sm INNER JOIN scrap scr ON scr.id=sm.scrapid) ON o.id=sm.oid )
         * INNER JOIN useraddress a ON o.aid=a.id WHERE o.uid = ?)a
         * Parameters: 1001(String)
         * Preparing: select o.id,o.state,o.updateTime,o.price,
         * c.id col_id, c.realName col_realName,
         * a.id ua_id, a.address ua_address, a.name ua_name,
         * u.openid u_openid,
         * sm.weight sm_weight, scr.name scr_name from (
         * ( ( orderform o INNER JOIN user u ON o.uid=u.openid ) LEFT JOIN collector c ON o.cid=c.id ) LEFT JOIN
         * (scrapmessage sm INNER JOIN scrap scr ON scr.id=sm.scrapid) ON o.id=sm.oid ) INNER JOIN
         * useraddress a ON o.aid=a.id WHERE o.uid = ? limit 0,3
         * Parameters: 1001(String)
         * Total: 2
         */
        Page page=new Page(3);
        System.out.println(selectService.selectOrdersByUid("1001",page));
    }

    @Test
    public void selectAddressByUid() {
        /**
         * Preparing: select a.id,a.address,a.detail,a.phoneNumber,a.name, m.id comm_id, m.address comm_address, m.name comm_name from useraddress a INNER JOIN community m ON a.community_id=m.id where a.uid=? order BY a.id
         * Parameters: 1001(String)
         * Total: 2
         */
        System.out.println(selectService.selectAddressByUid("1001"));
    }

    @Test
    public void filterOrders() {
        /**
         * 通过
         */
        Orderform orderform=new Orderform();
        Page page=new Page(3);
        orderform.setUpdateTime("2018-04");
        System.out.println(selectService.filterOrders(orderform,page));
    }

    @Test
    public void selectOrderByOid() {
        /**
         * Preparing: select o.id,o.state,o.weight,o.createTime,o.appointTime,date_format(o.updateTime,'%Y-%m-%d %H:%i:%s') updateTime,o.price,o.weight_state, c.id col_id, c.realName col_realName, c.sex col_sex, c.phoneNumber col_phoneNumber, c.idCardNum col_idCardNum, c.createTime col_createTime, c.avater col_avater, c.state col_state, c.volume col_volume, a.id ua_id, a.name ua_name, a.address ua_address, u.avater u_avater, u.openid u_openid, sm.weight sm_weight, sm.price sm_price, scr.id scr_id, scr.name scr_name from ( ( ( orderform o INNER JOIN user u ON o.uid=u.openid ) LEFT JOIN collector c ON o.cid=c.id ) LEFT JOIN (scrapmessage sm INNER JOIN scrap scr ON scr.id=sm.scrapid) ON o.id=sm.oid ) INNER JOIN useraddress a ON o.aid=a.id where o.id=?
         * Parameters: 1(Long)
         * Total: 1
         * Orderform{id=1, uid='null', cid=null, aid=null, state=1, weight=null, createTime=2018-04-12 19:40:58.0, appointTime=2018-04-12 19:40:57.0, updateTime=2018-04-29 10:39:12, price=null, rank=null, user=User{openid='1001', avater='user/document/test.jpg', state=0, addressList=null, accountList=null}, collector=Collector{id=1, openid='null', realName='江铮', sex='男', avater='/testAvater.jpg', phoneNumber='13867888451', password='null', photo='null', idCardNum='330283199710211418', idCardFrontPhoto='null', idCardBackPhoto='null', volume=0, createTime=2018-04-12 16:58:04.0, state=1, staid=null, station=null}, address=UserAddress{id=4, uid='null', address='浙江省杭州市浙江科技学院小和山校区', detail='null', phoneNumber='null', name='汪宏斌', community_id=0, community=null, locationX=null, locationY=null, geohash='null', user=null}, scrapMessageList=[ScrapMessage{oid=0, scrapid=0, weight=4.5, price=0.3, scrap=Scrap{id=3, typeName='null', name='钢化玻璃', unitPrice=null, monthVolume=null, totalVolume=null}, orderform=null}]}
         */
        System.out.println(selectService.selectOrderByOid("1"));
    }

    @Test
    public void selectCollectorByCid() {
        /**
         * Collector{id=6, openid='null', realName='江铮', sex='男', avater='/testAvater.jpg',
         * phoneNumber='13867888452', password='null', photo='/testphoto.jpg', idCardNum='330283199710211416', idCardFrontPhoto='/testfront.jpg', idCardBackPhoto='/testback.jpg', volume=0, createTime=2018-04-12 16:45:21.0, state=1, staid=null,
         * station=Station{id=2, name='更改测试', address='更改地址', detailed_address='更改细节', locationX=0.0, locationY=0.0, collectorList=null, consultantList=null}}
         */
        System.out.println(selectService.selectCollectorByCid("6"));
    }

    @Test
    public void filterCollector() {
        /**
         * Collector{id=1, openid='123', realName='江铮', sex='男', avater='/testAvater.jpg', phoneNumber='13867888451', password='null', photo='/testphoto.jpg', idCardNum='330283199710211418', idCardFrontPhoto='/testfront.jpg', idCardBackPhoto='/testback.jpg', volume=0, createTime=2018-04-12 16:58:04.0, state=1, staid=null, station=Station{id=2, name='更改测试', address='更改地址', detailed_address='更改细节', locationX=0.0, locationY=0.0, collectorList=null, consultantList=null}}, Collector{id=6, openid='null', realName='江铮', sex='男', avater='/testAvater.jpg', phoneNumber='13867888452', password='null', photo='/testphoto.jpg', idCardNum='330283199710211416', idCardFrontPhoto='/testfront.jpg', idCardBackPhoto='/testback.jpg', volume=0, createTime=2018-04-12 16:45:21.0, state=1, staid=null, station=Station{id=2, name='更改测试', address='更改地址', detailed_address='更改细节', locationX=0.0, locationY=0.0, collectorList=null, consultantList=null}}]
         */
        Collector collector=new Collector();
        Page page=new Page(2);
        collector.setRealName("江铮");
        System.out.println(selectService.filterCollector(collector,page));
    }

    @Test
    public void filterScraps() {
        /**
         * Scrap{id=3, typeName='玻璃', name='钢化玻璃', unitPrice=11.1, monthVolume=0.0, totalVolume=0.0},
         * Scrap{id=4, typeName='玻璃', name='钢化玻璃', unitPrice=11.1, monthVolume=50.0, totalVolume=50.0}]
         */
        Scrap scrap=new Scrap();
        Page page= new Page(3);
        scrap.setTypeName("玻璃");
        System.out.println(selectService.filterScraps(scrap,page));
    }
}