package org.cbb.wasteRecovery.bean;

/**
 * Created by Colossus on 2018/3/17.
 */
public class UserAddress {
    private int id;
    private int uid;
    private String address;//附近地址
    private String fullADD;//详细地址

    //经度
    private double locationX;
    //纬度
    private double locationY;

    private String geohash;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFullADD() {
        return fullADD;
    }

    public void setFullADD(String fullADD) {
        this.fullADD = fullADD;
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

    public void setGeohash(String geohash) {
        this.geohash = geohash;
    }
}
