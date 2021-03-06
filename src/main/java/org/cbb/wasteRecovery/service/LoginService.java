package org.cbb.wasteRecovery.service;

import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.bean.Consultant;
import org.cbb.wasteRecovery.bean.User;

import javax.servlet.http.HttpSession;

public interface LoginService {
    /**
     * 用户凭借openid登录
     * @param code
     * @return
     */
    User userLogin(String code);

    /**
     * 回收员登录
     * @param phoneNumber
     * @param password
     * @return
     */
    Collector collectorLogin(String phoneNumber,String password,String openid);

    /**
     * 回收员根据openid登录
     * @param openid
     * @return
     */
    Collector collectorLogin(String openid);


    /**
     * 咨询员登录
     * @param username
     * @param password
     * @return
     */
    Consultant consultantLogin(String username,String password);

    /**
     * 咨询员退出登录
     * @param httpSession 存有咨询员对象的session
     * @return
     */
    boolean consultantSignOut(HttpSession httpSession);
}
