package org.cbb.wasteRecovery.service;

import org.cbb.wasteRecovery.bean.Collector;

public interface RegisterService {
    /**
     * 验证手机号是否存在
     * @param phoneNumber
     * @return 存在返回false,不存在返回true
     */
    boolean validatePhone(String phoneNumber);

    /**
     * 验证身份证账号是否存在
     * @param IdCardNum
     * @return 存在返回false,不存在返回true
     */
    boolean validateIdCardNum(String IdCardNum);

    /**
     * 回收员注册
     * @param collector
     * @return
     */
    boolean RegisteCollector(Collector collector);

    /**
     * 验证用户名是否存在
     * @param username
     * @return 存在返回false,不存在返回true
     */
    boolean validateUsername(String username);

    /**
     * 咨询员注册
     * @param username
     * @param password
     * @param staid
     * @return
     */
    boolean RegisteConsultant(String username,String password,String staid);
}
