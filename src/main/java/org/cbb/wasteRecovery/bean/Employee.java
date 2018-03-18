package org.cbb.wasteRecovery.bean;

import java.sql.Timestamp;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Employee {
    private int id;
    private int staid;
    private int adminid;
    private String username;
    private String password;
    private Timestamp createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStaid() {
        return staid;
    }

    public void setStaid(int staid) {
        this.staid = staid;
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
