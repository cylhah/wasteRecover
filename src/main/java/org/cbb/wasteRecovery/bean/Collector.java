package org.cbb.wasteRecovery.bean;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Collector {
    private int id;
    private String realName;
    private char sex;
    private String avater;//头像地址
    private String phoneNumber;
    private String password;
    private String photo;//真人照片地址
    private String idCardNum;//身份证号
    private String idCardFrontPhoto;//身份证正面照地址
    private String idCardBackPhoto;//身份证背面照地址
    private int volume;//成交量
    private Timestamp createTime;
    private int state;
    private int staid;

    private Station station;
    private List<Orderform> unDidOrderformList;//负责小区内未完成订单
    private List<Orderform> DidOrderformList;//已完成订单
    private List<Community> communityList;//负责小区

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIdCardNum() {
        return idCardNum;
    }

    public void setIdCardNum(String idCardNum) {
        this.idCardNum = idCardNum;
    }

    public String getIdCardFrontPhoto() {
        return idCardFrontPhoto;
    }

    public void setIdCardFrontPhoto(String idCardFrontPhoto) {
        this.idCardFrontPhoto = idCardFrontPhoto;
    }

    public String getIdCardBackPhoto() {
        return idCardBackPhoto;
    }

    public void setIdCardBackPhoto(String idCardBackPhoto) {
        this.idCardBackPhoto = idCardBackPhoto;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getStatid() {
        return staid;
    }

    public void setStatid(int statid) {
        this.staid = statid;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Orderform> getUnDidOrderformList() {
        return unDidOrderformList;
    }

    public void setUnDidOrderformList(List<Orderform> unDidOrderformList) {
        this.unDidOrderformList = unDidOrderformList;
    }

    public List<Community> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(List<Community> communityList) {
        this.communityList = communityList;
    }

    public List<Orderform> getDidOrderformList() {
        return DidOrderformList;
    }

    public void setDidOrderformList(List<Orderform> didOrderformList) {
        DidOrderformList = didOrderformList;
    }
}


