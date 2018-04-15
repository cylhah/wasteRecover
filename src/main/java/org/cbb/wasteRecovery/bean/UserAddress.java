package org.cbb.wasteRecovery.bean;

import org.cbb.wasteRecovery.entity.GeoHash;

/**
 * Created by Colossus on 2018/3/17.
 */
public class UserAddress {
    private int id;
    private String uid;
    private String address;//附近地址
    private String detail;//详细地址
    private String phoneNumber;
    private String name;//出货人信息
    private int community_id;

    private Community community;

    //经度
    private double locationX;
    //纬度
    private double locationY;

    private String geohash;

    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLocationX() {
        return locationX;
    }

    public void setLocationX(double locationX) {
        this.locationX = locationX;
    }

    public double getLocationY() {
        return locationY;
    }

    public void setLocationY(double locationY) {
        this.locationY = locationY;
    }

    public String getGeohash() {
        return geohash;
    }

    public void setGeohash() {
        GeoHash geoHashMaker=new GeoHash();
        geohash=geoHashMaker.encode(locationX,locationY);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(int community_id) {
        this.community_id = community_id;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", address='" + address + '\'' +
                ", detail='" + detail + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                ", community_id=" + community_id +
                ", community=" + community +
                ", locationX=" + locationX +
                ", locationY=" + locationY +
                ", geohash='" + geohash + '\'' +
                ", user=" + user +
                '}';
    }
}
