package org.cbb.wasteRecovery.enums;

public enum CollectorStateEnum {
    BLACK(0,"非法用户"),
    NORMAL(1,"普通用户");


    private int state;
    private String info;

    CollectorStateEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public static CollectorStateEnum stateof(int index){
        for(CollectorStateEnum state:values()){
            if (state.getState()==index)
                return state;
        }
        return null;
    }
}
