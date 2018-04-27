package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.bean.Consultant;
import org.cbb.wasteRecovery.dao.CollectorDao;
import org.cbb.wasteRecovery.dao.ConsultantDao;
import org.cbb.wasteRecovery.entity.Page;
import org.cbb.wasteRecovery.enums.filter.CollectorFilterEnum;
import org.cbb.wasteRecovery.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImp implements RegisterService {
    @Autowired
    private CollectorDao collectorDao;

    @Autowired
    private ConsultantDao consultantDao;

    public boolean validatePhone(String phoneNumber) {
        if(phoneNumber==null||phoneNumber.equals(""))
            return false;
        Map constrains=new HashMap();
        constrains.put(CollectorFilterEnum.PHONE_NUMBER.getColumn(),phoneNumber);
        List<Collector> collectorList=collectorDao.filterCollPage(constrains,new Page(1));
        return collectorList.size()>0?false:true;
    }

    public boolean validateIdCardNum(String IdCardNum) {
        if(IdCardNum==null||IdCardNum.equals(""))
            return false;
        Map constrains=new HashMap();
        constrains.put(CollectorFilterEnum.IDCARD_NUM.getColumn(),IdCardNum);
        List <Collector> collectorList=collectorDao.filterCollPage(constrains,new Page(1));
        return collectorList.size()>0?false:true;
    }

    public boolean RegisteCollector(Collector collector) {
        if(collector==null) return false;
        int len=collectorDao.insertCollector(collector);
        return len>0?true:false;
    }

    public boolean validateUsername(String username) {
        if(username==null||username.equals(""))
            return false;
        return consultantDao.selectByUsername(username)!=null?false:true;
    }

    public boolean RegisteConsultant(String username, String password,String staid) {
        if(username==null||password==null||username.equals("")||password.equals(""))
            return false;
        int len=consultantDao.insertConsultant(Integer.parseInt(staid),username,password);
        return len>0?true:false;
    }
}
