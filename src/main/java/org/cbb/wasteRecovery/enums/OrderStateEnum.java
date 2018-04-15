package org.cbb.wasteRecovery.enums;

public enum OrderStateEnum {
    SUBMIT(1,"已提交"),
    COMPLETE(2,"已完成"),
    REQUEST_UPDATE(3,"请求更改"),
    REQUEST_CANCEL(4,"请求取消");

    private int state;
    private String info;

    OrderStateEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public static OrderStateEnum stateof(int index){
        for(OrderStateEnum state:values()){
            if (state.getState()==index)
                return state;
        }
        return null;
    }
}
