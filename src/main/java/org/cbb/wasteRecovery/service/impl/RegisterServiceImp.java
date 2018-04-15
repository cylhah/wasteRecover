package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.service.RegisterService;

public class RegisterServiceImp implements RegisterService {
    public boolean validatePhone(String phoneNumber) {
        return false;
    }

    public boolean validateIdCardNum(String IdCardNum) {
        return false;
    }

    public boolean RegisteCollector(Collector collector) {
        return false;
    }

    public boolean validateUsername(String username) {
        return false;
    }

    public boolean RegisteConsultant(String username, String password) {
        return false;
    }
}
