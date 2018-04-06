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

        Orderform orderform=new Orderform();
        orderform.setWeight(5.2);
        Timestamp ts=new Timestamp(new Date().getTime());
        orderform.setCreateTime(ts);
        Timestamp t1=new Timestamp(new Date().getTime());


        orderformDao.insertOrderform(orderform);

    }

    @Test
    public void selectById() throws Exception{

        Orderform orderform=orderformDao.selectById(5);
        System.out.println(orderform);
    }

    @Test
    public void selectByCId() throws Exception{


    }

    @Test
    public void selectByUId() throws Exception{


    }

    @Test
    public void selectByEId() throws Exception{


    }

    @Test
    public void selectByStaId() throws Exception{


    }

    @Test
    public void selectByState() throws Exception{

        List<Orderform> orderform=orderformDao.selectByState(1);
        for(Orderform orderform1:orderform)
        {
            System.out.println(orderform1);
        }
    }

    @Test
    public void selectByPosAndTime() throws Exception{


    }
    @Test
    public void selectByTime() throws Exception{
        Orderform orderform1=new Orderform();
        Timestamp ts=new Timestamp(2018-03-23);


    }

    @Test
    public void updateWeight() throws Exception{

        Orderform orderform1=new Orderform();
        orderform1.setWeight(6.23);
        orderform1.setId(5);

    }

    @Test
    public void updateState() throws Exception{

        Orderform orderform1=new Orderform();
        orderform1.setState(2);
        orderform1.setId(5);

    }

    @Test
    public void updateData() throws Exception{

        Orderform orderform=new Orderform();
        orderform.setPrice(5.31);
        orderform.setState(1);
        orderform.setAid(5);


        orderform.setWeight(61.23);

    }

    @Test
    public void deleteOrderform() throws Exception{

        orderformDao.deleteOrderform(6);
    }

}
