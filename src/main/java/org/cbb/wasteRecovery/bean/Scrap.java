package org.cbb.wasteRecovery.bean;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Scrap {
    private int id;
    private int tid;//种类id
    private String name;//废品名称
    private double unitPriceFU;//对用户的单价
    private double unitPriceFC;//对回收人员的单价
    private double monthVolume;//月成交额
    private double totalVolume;//总成交额

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPriceFU() {
        return unitPriceFU;
    }

    public void setUnitPriceFU(double unitPriceFU) {
        this.unitPriceFU = unitPriceFU;
    }

    public double getUnitPriceFC() {
        return unitPriceFC;
    }

    public void setUnitPriceFC(double unitPriceFC) {
        this.unitPriceFC = unitPriceFC;
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
