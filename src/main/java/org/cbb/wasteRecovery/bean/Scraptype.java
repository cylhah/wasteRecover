package org.cbb.wasteRecovery.bean;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Scraptype {
    private int id;
    private String typeName;
    private double avergePriceFU;//对用户的平均单价
    private double avergePriceFC;//对回收人员的平均单价

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

    public double getAvergePriceFU() {
        return avergePriceFU;
    }

    public void setAvergePriceFU(double avergePriceFU) {
        this.avergePriceFU = avergePriceFU;
    }

    public double getAvergePriceFC() {
        return avergePriceFC;
    }

    public void setAvergePriceFC(double avergePriceFC) {
        this.avergePriceFC = avergePriceFC;
    }
}
