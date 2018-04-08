package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.bean.Consultant;
import org.cbb.wasteRecovery.bean.User;
import org.cbb.wasteRecovery.service.LoginService;

import javax.servlet.http.HttpSession;

public class LoginServiceImp implements LoginService {
    public User userLogin(String openid) {
        return null;
    }

    public Collector collectorLogin(String phoneNumber, String password) {
        return null;
    }

    public boolean collectorSignOut(HttpSession httpSession) {
        return false;
    }

    public Consultant consultantLogin(String phoneNumber, String password) {
        return null;
    }

    public boolean consultantSignOut(HttpSession httpSession) {
        return false;
    }
}
