package org.cbb.wasteRecovery.service.impl;

import net.sf.json.JSONObject;
import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.bean.ScrapMessage;
import org.cbb.wasteRecovery.bean.UserAddress;
import org.cbb.wasteRecovery.dao.*;
import org.cbb.wasteRecovery.entity.OrderformExecute;
import org.cbb.wasteRecovery.entity.weixin.AccessToken;
import org.cbb.wasteRecovery.entity.weixin.Data;
import org.cbb.wasteRecovery.entity.weixin.TpMess;
import org.cbb.wasteRecovery.util.Validate;
import org.cbb.wasteRecovery.enums.OrderStateEnum;
import org.cbb.wasteRecovery.enums.SubmitOrderStatus;
import org.cbb.wasteRecovery.exception.ComplRepeatException;
import org.cbb.wasteRecovery.exception.CompleteOrderException;
import org.cbb.wasteRecovery.exception.MessageFormatException;
import org.cbb.wasteRecovery.service.TradeService;
import org.cbb.wasteRecovery.util.WeiXinHttpOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TradeServiceImp implements TradeService {
    private final String SUB_ORD_TEMPID="GQgs-O30lhBN5SnkcDWOlbPYTFsJQJAi6OQeIjDRcE0";
    private final String RECIVE_ORD_TEMPID="Qlb5nWyKvLWME9_tAvoaYhoC8Kukh3suOPn1Fyf5ATs";
    private final String CANCEL_TEMPID="XVH82zryNibge_JaoqhAzuLZxlsm83q32dB4XuLr570";
    private final String PUSHURL="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    private final String userloginUrl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx6ef3f5bd2ef0dbe3&redirect_uri=http%3A%2F%2Fcw22nq.natappfree.cc%2Fuser%2Flogin&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
    private final String collLoginUrl=userloginUrl.replace("user","collector");

    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private OrderformDao orderformDao;

    @Autowired
    private CollectorDao collectorDao;

    @Autowired
    private ScrapMessageDao scrapMessageDao;

    @Autowired
    private UserAddressDao userAddressDao;

    private Map tempMatch(Orderform orderform,UserAddress userAddress){
        Map map=new HashMap();
        Data data1=new Data();
        data1.setValue(String.valueOf(orderform.getId()));
        data1.setColor("#000000");
        Data data2=new Data();
        data2.setValue(String.valueOf(userAddress.getName()));
        data2.setColor("#000000");
        Data data3=new Data();
        data3.setValue(userAddress.getAddress());
        data3.setColor("#000000");
        Data data4=new Data();
        data4.setValue(userAddress.getPhoneNumber());
        data4.setColor("#000000");

        map.put("keyword1",data1);
        map.put("keyword2",data2);
        map.put("keyword3",data3);
        map.put("keyword4",data4);

        return map;
    }

    public OrderformExecute submitOrderform(Orderform orderform) {
        if(orderform==null||!Validate.validateSubmitOrder(orderform))
            return new OrderformExecute(orderform,SubmitOrderStatus.FORMAT_EXCEPRION);

        int num=orderformDao.insertOrderform(orderform.getAppointTime(),
                orderform.getAid(),orderform.getUid(),orderform.getWeightState());
        if(num==0)
            return new OrderformExecute(orderform,SubmitOrderStatus.FORMAT_EXCEPRION);

        orderform.setState(OrderStateEnum.SUBMIT.getState());
        OrderformExecute orderformExecute=new OrderformExecute(orderform, SubmitOrderStatus.SUCCESS);

        //推送给回收员消息（未测试,可进行多线程优化）
        String openid=collectorDao.selectById(orderform.getCid()).getOpenid();
        UserAddress userAddress=userAddressDao.selectById(orderform.getAid());
        TpMess tpMess=new TpMess();
        tpMess.setTemplate_id(SUB_ORD_TEMPID);
        tpMess.setTouser(openid);
        tpMess.setUrl(collLoginUrl);
        Map map=tempMatch(orderform,userAddress);
        tpMess.setData(map);

        String aurl=PUSHURL.replace("ACCESS_TOKEN",AccessToken.getAccess_token().getCode());
        WeiXinHttpOperation.doPost(aurl,JSONObject.fromObject(tpMess).toString());

        return orderformExecute;
    }

    public boolean receiveOrderform(Orderform orderform) {
        if(orderform==null)
            return false;
        if(orderformDao.updateCollectorAndState(orderform.getId(),OrderStateEnum.RECEIVED.getState(),orderform.getCid())<1)
            return false;

        //推送消息
        String openid=orderform.getUid();
        Collector collector=collectorDao.selectById(orderform.getCid());
        TpMess tpMess=new TpMess();
        tpMess.setTemplate_id(RECIVE_ORD_TEMPID);
        tpMess.setTouser(openid);
        tpMess.setUrl(userloginUrl);
        Map map=new HashMap();
        Data data1=new Data();
        data1.setValue(String.valueOf(orderform.getId()));
        data1.setColor("#000000");
        Data data2=new Data();
        data2.setValue(collector.getRealName());
        data2.setColor("#000000");
        Data data3=new Data();
        data3.setValue(collector.getPhoneNumber());
        data3.setColor("#000000");

        map.put("keyword1",data1);
        map.put("keyword2",data2);
        map.put("keyword3",data3);
        return true;
    }

    public boolean requestCancleOrder(String id) {
        if(id.equals("")||id==null)
            return false;
        if(orderformDao.updateOrderform(Long.parseLong(id),OrderStateEnum.REQUEST_CANCEL.getState())==0)
            return false;
        Orderform orderform=orderformDao.selectById(Long.parseLong(id));
        //推送给回收员消息（未测试）
        String openid=orderform.getCollector().getOpenid();
        UserAddress userAddress=orderform.getAddress();
        TpMess tpMess=new TpMess();
        tpMess.setTemplate_id(CANCEL_TEMPID);
        tpMess.setTouser(openid);
        tpMess.setUrl(collLoginUrl);
        Map map=tempMatch(orderform,userAddress);
        tpMess.setData(map);

        String aurl=PUSHURL.replace("ACCESS_TOKEN",AccessToken.getAccess_token().getCode());
        WeiXinHttpOperation.doPost(aurl,JSONObject.fromObject(tpMess).toString());
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
