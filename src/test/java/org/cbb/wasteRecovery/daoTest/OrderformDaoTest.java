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
        int aid=2;
        String uid="qwer";
        int state=1;

        int i=orderformDao.insertOrderform(createTime,appointTime, aid, uid, state);
        System.out.println(i);
    }
    //返回值为1


    @Test
    public void selectById() throws Exception{

        Orderform orderform=orderformDao.selectById(1);
        System.out.println(orderform);
    }
    //返回值为org.cbb.wasteRecovery.bean.Orderform@189cbd7c


    @Test
    public void selectByCId() throws Exception{

        int cid=1;
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

        String uid="qw";
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
    //返回值为org.cbb.wasteRecovery.bean.Orderform@1ea9f009


    @Test
    public void selectByPositon() throws Exception{

        double locationX=1.2;
        double locationY=2.1;
        String geohash="asd";
        double distance=10000;
        int offset=0;
        int limit=1;
        List<Orderform> Orderform= orderformDao.selectByPositon(locationX,locationY,geohash,distance,offset,limit);
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
