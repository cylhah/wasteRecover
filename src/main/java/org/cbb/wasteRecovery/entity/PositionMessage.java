package org.cbb.wasteRecovery.entity;

public class PositionMessage {
    private String address;
    private String geohash;
    private double locationX;
    private double locationY;

    public String getGeohash() {
        return geohash;
    }

    public void setGeohash(String geohash) {
        this.geohash = geohash;
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

    public double getDistance(PositionMessage positionMessage){
        double dx=positionMessage.getLocationX()-locationX;
        double dy=positionMessage.getLocationY()-locationY;
        return Math.sqrt(dx*dx+dy*dy);
    }
}
