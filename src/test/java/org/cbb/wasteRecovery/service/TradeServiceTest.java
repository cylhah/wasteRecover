package org.cbb.wasteRecovery.service;

import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.bean.Scrap;
import org.cbb.wasteRecovery.bean.ScrapMessage;
import org.cbb.wasteRecovery.enums.WeightStateEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration({"classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"})
public class TradeServiceTest {

    @Autowired
    TradeService tradeService;


    @Test
    public void submitOrderform() {
        /**
         * OrderformExecute{state=1, info='提交成功',
         * orderform=Orderform{id=null, uid='1000', cid=null, aid=2, state=0, weight=null,
         * createTime=null, appointTime=2018-04-28 20:23:45.817,..}
         */
        Orderform orderform=new Orderform();
        orderform.setUid("1000");
        orderform.setAid(2);
        orderform.setWeightState(WeightStateEnum.LIGHT.getState());
        orderform.setAppointTime(new Timestamp(new Date().getTime()));
        System.out.println(tradeService.submitOrderform(orderform));
    }

    @Test
    public void receiveOrderform() {
        /**
         * true
         */
        Orderform orderform=new Orderform();
        orderform.setCid(6);
        orderform.setId(4L);
        System.out.println(tradeService.receiveOrderform(orderform));
    }

    @Test
    public void requestCancleOrder() {
        /**
         * Preparing: update orderform set state=? where id = ?
         * Parameters: 4(Integer), 3(Long)
         * Updates: 1
         */
        tradeService.requestCancleOrder("3");
    }

    @Test
    public void completeOrder() {
        Orderform orderform=new Orderform();
        orderform.setId(4L);
        List<ScrapMessage> scrapMessageList=new ArrayList<ScrapMessage>();
        for(int i=0;i<3;i++) {
            ScrapMessage scrapMessage = new ScrapMessage();
            scrapMessage.setScrapid(3);
            scrapMessage.setWeight(1.7+i);
            scrapMessage.setPrice((1.7+i)*0.2);
            scrapMessageList.add(scrapMessage);
        }
        orderform.setScrapMessageList(scrapMessageList);
        System.out.println(tradeService.completeOrder(orderform));
    }

    @Test
    public void gradeOrderform() {
        /**
         * Preparing: update orderform set rank=? where id = ?
         * Parameters: 5(Integer), 2(Long)
         * Updates: 1
         * true
         */
        Orderform orderform=new Orderform();
        orderform.setId(2L);
        orderform.setRank(5);
        System.out.println(tradeService.gradeOrderform(orderform));
    }

    @Test
    public void cancelOrder() {
        /**
         * Preparing: delete from orderform where id=?
         * Parameters: 3(Long)
         * Updates: 1
         * true
         */
        System.out.println(tradeService.cancelOrder("3"));
    }
}