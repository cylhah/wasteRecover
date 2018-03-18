package org.cbb.wasteRecovery.bean;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Orderform {
    private long id;
    private int uid;//用户id
    private int cid;//回收人员id
    private int eid;//员工id
    private int aid;//地址id
    private int state;//订单状态
    private double weight;//订单重量
    private Timestamp createTime;
    private Timestamp appointSTime;//预约时间段初始时刻
    private Timestamp appointETime;//预约结束时间
    private Timestamp updateTime;//信息更新时间(数据库自动更新)
    private double price;//订单最终成交价格

    private User user;
    private Collector collector;
    private Employee employee;
    private UserAddress address;
    private List<Scraptype> scraptypeList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getEid() {
        return eid;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getAppointSTime() {
        return appointSTime;
    }

    public void setAppointSTime(Timestamp appointSTime) {
        this.appointSTime = appointSTime;
    }

    public Timestamp getAppointETime() {
        return appointETime;
    }

    public void setAppointETime(Timestamp appointETime) {
        this.appointETime = appointETime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public List<Scraptype> getScraptypeList() {
        return scraptypeList;
    }

    public void setScraptypeList(List<Scraptype> scraptypeList) {
        this.scraptypeList = scraptypeList;
    }
}
