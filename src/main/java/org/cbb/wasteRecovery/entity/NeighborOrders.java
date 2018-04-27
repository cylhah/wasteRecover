package org.cbb.wasteRecovery.entity;

import org.cbb.wasteRecovery.bean.Orderform;

import java.util.List;

public class NeighborOrders {
    private int number;
    private List<Orderform> orderformList;

    public NeighborOrders(List<Orderform> orderformList) {
        this.orderformList = orderformList;
        number=orderformList.size();
    }

    public int getNumber() {
        return number;
    }

    public List<Orderform> getOrderformList() {
        return orderformList;
    }
}
