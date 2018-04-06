package org.cbb.wasteRecovery.bean;

import java.util.List;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Station {
    private int id;
    private String name;
    private String address;
    private String detailed_address;

    //经度
    private double locationX;
    //纬度
    private double locationY;

    private List<Collector> collectorList;
    private List<Consultant> consultantList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailed_address() {
        return detailed_address;
    }

    public void setDetailed_address(String detailed_address) {
        this.detailed_address = detailed_address;
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

    public List<Collector> getCollectorList() {
        return collectorList;
    }

    public void setCollectorList(List<Collector> collectorList) {
        this.collectorList = collectorList;
    }

    public List<Consultant> getConsultantList() {
        return consultantList;
    }

    public void setConsultantList(List<Consultant> consultantList) {
        this.consultantList = consultantList;
    }
}
