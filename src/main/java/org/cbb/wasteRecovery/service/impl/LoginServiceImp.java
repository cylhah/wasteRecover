package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.bean.Consultant;
import org.cbb.wasteRecovery.bean.User;
import org.cbb.wasteRecovery.dao.CollectorDao;
import org.cbb.wasteRecovery.dao.ConsultantDao;
import org.cbb.wasteRecovery.dao.UserDao;
import org.cbb.wasteRecovery.enums.UserStateEnum;
import org.cbb.wasteRecovery.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImp implements LoginService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private CollectorDao collectorDao;

    @Autowired
    private ConsultantDao consultantDao;

    public User userLogin(String openid) {
        if(openid.equals("")||openid==null)
            return null;
        if (userDao.selectById(openid)==null){
            userDao.insertUser(openid,UserStateEnum.NORMAL.getState());

        }
        return userDao.selectById(openid);
    }

    public Collector collectorLogin(String phoneNumber, String password) {
        if(phoneNumber.equals("")||password.equals("")||phoneNumber==null||password==null)
            return null;
        return collectorDao.selectByPhoneNumAndPass(phoneNumber,password);
    }

    public boolean collectorSignOut(HttpSession httpSession) {
        return false;
    }

    public Consultant consultantLogin(String username, String password) {
        if(username.equals("")||password.equals("")||username==null||password==null)
            return null;
        return consultantDao.selectByUsernameAndPass(username,password);
    }

    public boolean consultantSignOut(HttpSession httpSession) {
        return false;
    }
}
