package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.bean.Scrap;
import org.cbb.wasteRecovery.bean.ScrapMessage;
import org.cbb.wasteRecovery.dao.OrderformDao;
import org.cbb.wasteRecovery.dao.ScrapDao;
import org.cbb.wasteRecovery.dao.ScrapMessageDao;
import org.cbb.wasteRecovery.entity.OrderformExecute;
import org.cbb.wasteRecovery.entity.Validate;
import org.cbb.wasteRecovery.enums.OrderStateEnum;
import org.cbb.wasteRecovery.enums.SubmitOrderStatus;
import org.cbb.wasteRecovery.exception.ComplRepeatException;
import org.cbb.wasteRecovery.exception.CompleteOrderException;
import org.cbb.wasteRecovery.exception.MessageFormatException;
import org.cbb.wasteRecovery.service.TradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class TradeServiceImp implements TradeService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrderformDao orderformDao;

    private ScrapMessageDao scrapMessageDao;

    private ScrapDao scrapDao;

    public OrderformExecute submitOrderform(Orderform orderform) {
        Timestamp createTime=new Timestamp(new Date().getTime());
        if(orderform==null||Validate.validateSubmitOrder(orderform))
            return new OrderformExecute(orderform,SubmitOrderStatus.FORMAT_EXCEPRION);
        int num=orderformDao.insertOrderform(orderform.getAppointTime(),
                orderform.getAid(),orderform.getUid());
        if(num==0)
            return new OrderformExecute(orderform,SubmitOrderStatus.FORMAT_EXCEPRION);

        orderform.setState(OrderStateEnum.SUBMIT.getState());
        orderform.setCreateTime(createTime);
        OrderformExecute orderformExecute=new OrderformExecute(orderform, SubmitOrderStatus.SUCCESS);
        return orderformExecute;
        //推送给回收员消息（未做）
    }

    public boolean requestCancleOrder(String id) {
        if(id.equals("")||id==null)
            return false;
        if(orderformDao.updateOrderform(Long.parseLong(id),OrderStateEnum.REQUEST_CANCEL.getState())==0)
            return false;
        //推送给回收员消息（未做）
        return true;
    }


    public OrderformExecute completeOrder(Orderform orderform) {
        if(orderform==null||Validate.validateComplOrder(orderform))
            return new OrderformExecute(orderform,SubmitOrderStatus.FORMAT_EXCEPRION);
        double price=0,weight=0;
        List<ScrapMessage> scrapMessageList=orderform.getScrapMessageList();
        //待改
        for (ScrapMessage scrapMessage : scrapMessageList) {
            Scrap scrap=scrapDao.selectByid(scrapMessage.getScrapid());
            double tempW=scrapMessage.getWeight();
            double tempP=tempW*scrap.getUnitPrice();
            weight+=tempW;
            price+=tempP;
            scrapMessage.setPrice(tempP);
        }
        orderform.setPrice(price);
        orderform.setWeight(weight);
        int i=0;
        try {

            for (ScrapMessage scrapMessage : scrapMessageList) {
                i=scrapMessageDao.insertScrapMessage(scrapMessage.getOid(), scrapMessage.getScrapid(),
                        scrapMessage.getWeight(), scrapMessage.getPrice());
                if(i==0)
                    throw  new ComplRepeatException("重复秒杀");
            }
            if(orderformDao.submitData(orderform)==0){
                throw new MessageFormatException("格式异常");
            }
            return new OrderformExecute(orderform,SubmitOrderStatus.SUCCESS);
        }
        catch (ComplRepeatException cre){
            throw cre;
        }
        catch (MessageFormatException me){
            throw me;
        }
        catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new CompleteOrderException("服务器内部异常："+e.getMessage());
        }
    }

    public boolean cancelOrder(String id) {
        if(id.equals("")||id==null)
            return false;
        if(orderformDao.deleteOrderform(Long.parseLong(id))==0)
            return false;
        return true;
    }
}
