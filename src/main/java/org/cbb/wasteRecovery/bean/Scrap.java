package org.cbb.wasteRecovery.bean;

/**
 * Created by Colossus on 2018/3/17.
 */
public class Scrap {
    private Integer id;
    private String typeName;//种类名称
    private String name;//废品名称
    private Double unitPrice;//废品单价
    private Double monthVolume;//本月成交额
    private Double totalVolume;//总成交额

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getMonthVolume() {
        return monthVolume;
    }

    public void setMonthVolume(Double monthVolume) {
        this.monthVolume = monthVolume;
    }

    public Double getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(Double totalVolume) {
        this.totalVolume = totalVolume;
    }

    @Override
    public String toString() {
        return "Scrap{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", monthVolume=" + monthVolume +
                ", totalVolume=" + totalVolume +
                '}';
    }
}
