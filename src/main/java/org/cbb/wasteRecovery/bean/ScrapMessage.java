package org.cbb.wasteRecovery.bean;

public class ScrapMessage {
    private long oid;//订单id
    private int scrapid;//废品id
    private double weight;//重量
    private double price;//价格

    private Scrap scrap;
    private Orderform orderform;

    public long getOid() {
        return oid;
    }

    public void setOid(long oid) {
        this.oid = oid;
    }

    public int getScrapid() {
        return scrapid;
    }

    public void setScrapid(int scrapid) {
        this.scrapid = scrapid;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Scrap getScrap() {
        return scrap;
    }

    public void setScrap(Scrap scrap) {
        this.scrap = scrap;
    }

    public Orderform getOrderform() {
        return orderform;
    }

    public void setOrderform(Orderform orderform) {
        this.orderform = orderform;
    }
}
