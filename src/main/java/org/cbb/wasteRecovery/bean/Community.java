package org.cbb.wasteRecovery.bean;


public class Community {
    private Integer id;
    private String address;//地址信息
    private Integer cid; //回收员id
    private String name; //小区名

    private Collector collector;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collector getCollector() {
        return collector;
    }

    public void setCollector(Collector collector) {
        this.collector = collector;
    }

    @Override
    public String toString() {
        return "Community{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                ", collector=" + collector +
                '}';
    }
}
