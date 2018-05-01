package org.cbb.wasteRecovery.bean;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Orderform {
    private Long id;
    private String uid;//用户id
    private Integer cid;//完成该订单的回收人员id
    private Integer aid;//地址id
    private Integer state;//订单状态
    private Double weight;//废品总重量
    private Timestamp createTime;
    private Timestamp appointTime;//预约时间
    private String updateTime;//信息更新时间(数据库自动更新)
    private Double price;//订单最终成交价格
    private Integer rank;
    private Integer weightState;

    private User user;
    private Collector collector;
    private UserAddress address;
    private List<ScrapMessage> scrapMessageList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
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

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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

    public Integer getWeightState() {
        return weightState;
    }

    public void setWeightState(Integer weightState) {
        this.weightState = weightState;
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
