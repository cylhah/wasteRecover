package org.cbb.wasteRecovery.bean;

import java.util.List;

/**
 * Created by Colossus on 2018/3/17.
 */
public class User {
    private String openid;
    private String avater;//头像地址
    private int state;//用户状态

    private List<UserAddress> addressList;
    private List<BankAccount> accountList;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<UserAddress> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<UserAddress> addressList) {
        this.addressList = addressList;
    }

    public List<BankAccount> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<BankAccount> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "User{" +
                "openid='" + openid + '\'' +
                ", avater='" + avater + '\'' +
                ", state=" + state +
                ", addressList=" + addressList +
                ", accountList=" + accountList +
                '}';
    }
}
