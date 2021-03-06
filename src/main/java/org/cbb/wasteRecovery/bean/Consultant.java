package org.cbb.wasteRecovery.bean;

public class Consultant {
    private int staid;
    private String username;
    private String password;

    private Station station;


    public int getStaid() {
        return staid;
    }

    public void setStaid(int staid) {
        this.staid = staid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "Consultant{" +
                " staid=" + staid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", station=" + station +
                '}';
    }
}
