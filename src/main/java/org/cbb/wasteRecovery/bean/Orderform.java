package org.cbb.wasteRecovery.bean;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Orderform {
    private long id;
    private String uid;//用户id
    private int cid;//完成该订单的回收人员id
    private int aid;//地址id
    private int state;//订单状态
    private double weight;//废品总重量
    private Timestamp createTime;
    private Timestamp appointTime;//预约时间
    private Timestamp updateTime;//信息更新时间(数据库自动更新)
    private double price;//订单最终成交价格
    private int rank;

    private User user;
    private Collector collector;
    private UserAddress address;
    private List<ScrapMessage> scrapMessageList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
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

    public Timestamp getAppointTime() {
        return appointTime;
    }

    public void setAppointTime(Timestamp appointTime) {
        this.appointTime = appointTime;
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

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public List<ScrapMessage> getScrapMessageList() {
        return scrapMessageList;
    }

    public void setScrapMessageList(List<ScrapMessage> scrapMessageList) {
        this.scrapMessageList = scrapMessageList;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Orderform{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", cid=" + cid +
                ", aid=" + aid +
                ", state=" + state +
                ", weight=" + weight +
                ", createTime=" + createTime +
                ", appointTime=" + appointTime +
                ", updateTime=" + updateTime +
                ", price=" + price +
                ", rank=" + rank +
                ", user=" + user +
                ", collector=" + collector +
                ", address=" + address +
                ", scrapMessageList=" + scrapMessageList +
                '}';
    }
}
