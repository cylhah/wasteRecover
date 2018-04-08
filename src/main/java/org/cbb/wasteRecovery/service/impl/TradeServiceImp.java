package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.dao.OrderformDao;
import org.cbb.wasteRecovery.entity.OrderformExecute;
import org.cbb.wasteRecovery.entity.Validate;
import org.cbb.wasteRecovery.enums.OrderStateEnum;
import org.cbb.wasteRecovery.enums.SubmitOrderStatus;
import org.cbb.wasteRecovery.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class TradeServiceImp implements TradeService {
    @Autowired
    private OrderformDao orderformDao;

    public OrderformExecute submitOrderform(Orderform orderform) {
        Timestamp createTime=new Timestamp(new Date().getTime());
        if(orderform==null||Validate.validateSubmitOrder(orderform))
            return new OrderformExecute(orderform,SubmitOrderStatus.FORMAT_EXCEPRION);
        int num=orderformDao.insertOrderform(createTime,orderform.getAppointTime(),
                orderform.getAid(),orderform.getUid(),OrderStateEnum.SUBMIT.getState());
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
        if(orderformDao.updateOrederform(Long.parseLong(id),OrderStateEnum.REQUEST_CANCEL.getState())==0)
            return false;
        //推送给回收员消息（未做）
        return true;
    }


    public OrderformExecute completeOrder(Orderform orderform) {    
        return null;
    }

    public boolean cancelOrder(String id) {
        return false;
    }
}
