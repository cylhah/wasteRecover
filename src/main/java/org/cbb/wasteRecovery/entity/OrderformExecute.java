package org.cbb.wasteRecovery.entity;

import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.bean.UserAddress;
import org.cbb.wasteRecovery.enums.SubmitOrderStatus;

import java.util.regex.Pattern;

public class OrderformExecute {
    private int state;
    private String info;
    private Orderform orderform;

    public OrderformExecute(Orderform orderform, SubmitOrderStatus submitOrderStatus) {
        this.orderform = orderform;
        state= submitOrderStatus.getState();
        info= submitOrderStatus.getInfo();
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public Orderform getOrderform() {
        return orderform;
    }


}
