package org.cbb.wasteRecovery.bean;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Collector {
    private Integer id;
    private String openid;
    private String realName;
    private String sex;
    private String avater;//头像地址
    private String phoneNumber;
    private String password;
    private String photo;//真人照片地址
    private String idCardNum;//身份证号
    private String idCardFrontPhoto;//身份证正面照地址
    private String idCardBackPhoto;//身份证背面照地址
    private Integer volume;//成交量
    private Timestamp createTime;
    private Integer state;
    private Integer staid;

    private Station station;
    private List<Community> communityList;//负责小区

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
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

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getStaid() {
        return staid;
    }

    public void setStaid(Integer staid) {
        this.staid = staid;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public List<Community> getCommunityList() {
        return communityList;
    }

    public void setCommunityList(List<Community> communityList) {
        this.communityList = communityList;
    }

    @Override
    public String toString() {
        return "Collector{" +
                "id=" + id +
                ", openid='" + openid + '\'' +
                ", realName='" + realName + '\'' +
                ", sex='" + sex + '\'' +
                ", avater='" + avater + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                ", idCardNum='" + idCardNum + '\'' +
                ", idCardFrontPhoto='" + idCardFrontPhoto + '\'' +
                ", idCardBackPhoto='" + idCardBackPhoto + '\'' +
                ", volume=" + volume +
                ", createTime=" + createTime +
                ", state=" + state +
                ", staid=" + staid +
                ", station=" + station +
                '}';
    }
}


