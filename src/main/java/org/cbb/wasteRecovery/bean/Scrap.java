package org.cbb.wasteRecovery.bean;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Scrap {
    private int id;
    private String typeName;//种类名称
    private String name;//废品名称
    private double unitPrice;//废品单价
    private double monthVolume;//本月成交额
    private double totalVolume;//总成交额

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getMonthVolume() {
        return monthVolume;
    }

    public void setMonthVolume(double monthVolume) {
        this.monthVolume = monthVolume;
    }

    public double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(double totalVolume) {
        this.totalVolume = totalVolume;
    }
}
