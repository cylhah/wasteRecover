package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.bean.Scrap;
import org.cbb.wasteRecovery.bean.ScrapMessage;
import org.cbb.wasteRecovery.dao.*;
import org.cbb.wasteRecovery.entity.MessageTransfer;
import org.cbb.wasteRecovery.entity.OrderformExecute;
import org.cbb.wasteRecovery.entity.TextMessage;
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
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TradeServiceImp implements TradeService {

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrderformDao orderformDao;

    @Autowired
    private CollectorDao collectorDao;

    @Autowired
    private ScrapMessageDao scrapMessageDao;

    public OrderformExecute submitOrderform(Orderform orderform) {
        if(orderform==null||!Validate.validateSubmitOrder(orderform))
            return new OrderformExecute(orderform,SubmitOrderStatus.FORMAT_EXCEPRION);

        int num=orderformDao.insertOrderform(orderform.getAppointTime(),
                orderform.getAid(),orderform.getUid(),orderform.getWeightState());
        if(num==0)
            return new OrderformExecute(orderform,SubmitOrderStatus.FORMAT_EXCEPRION);

        orderform.setState(OrderStateEnum.SUBMIT.getState());
        OrderformExecute orderformExecute=new OrderformExecute(orderform, SubmitOrderStatus.SUCCESS);

//        //推送给回收员消息（未测试）
//        String openid=collectorDao.selectById(orderform.getCid()).getOpenid();
//        String message=null;
//        if (openid!=null&&!openid.equals("")){
//            TextMessage textMessage=new TextMessage();
//            textMessage.setToUserName(openid);
//            textMessage.setFromUserName("我方id");
//            textMessage.setContent("您负责的小区有了新订单");
//            textMessage.setMsgType("text");
//            textMessage.setCreateTime(new Date().getTime());
//            message=MessageTransfer.textMessToXml(textMessage);
//        }

        return orderformExecute;
    }

    public boolean receiveOrderform(Orderform orderform) {
        if(orderform==null)
            return false;
        if(orderformDao.updateCollectorAndState(orderform.getId(),OrderStateEnum.RECEIVED.getState(),orderform.getCid())<1)
            return false;

        //推送消息
        return true;
    }

    public boolean requestCancleOrder(String id) {
        if(id.equals("")||id==null)
            return false;
        if(orderformDao.updateOrderform(Long.parseLong(id),OrderStateEnum.REQUEST_CANCEL.getState())==0)
            return false;
        //推送给回收员消息（未做）
        return true;
    }


    @Transactional
    public OrderformExecute completeOrder(Orderform orderform) {
        if(orderform==null||!Validate.validateComplOrder(orderform))
            return new OrderformExecute(orderform,SubmitOrderStatus.FORMAT_EXCEPRION);
        List<ScrapMessage> scrapMessageList=orderform.getScrapMessageList();
        orderform.setState(OrderStateEnum.COMPLETE.getState());
        int i=0;
        try {
            for (ScrapMessage scrapMessage : scrapMessageList) {
                i=scrapMessageDao.insertScrapMessage(orderform.getId(), scrapMessage.getScrapid(),
                        scrapMessage.getWeight(), scrapMessage.getPrice());
                if(i==0)
                    throw  new ComplRepeatException("重复提交");
            }
            if(orderformDao.submitData(orderform)==0){
                throw new MessageFormatException("格式异常");
            }
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
        return new OrderformExecute(orderform,SubmitOrderStatus.SUCCESS);
    }


    public boolean gradeOrderform(Orderform orderform) {
        if(orderformDao.updateRank(orderform.getId(),orderform.getRank())<1)
            return false;
        return true;
    }

    public boolean cancelOrder(String id) {
        if(id.equals("")||id==null)
            return false;
        if(orderformDao.deleteOrderform(Long.parseLong(id))==0)
            return false;
        return true;
    }
}
