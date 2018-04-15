package org.cbb.wasteRecovery.enums;

public enum  UserStateEnum {
    BLACK(0,"非法用户"),
    NORMAL(1,"普通用户");


    private int state;
    private String info;

    UserStateEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public static UserStateEnum stateof(int index){
        for(UserStateEnum state:values()){
            if (state.getState()==index)
                return state;
        }
        return null;
    }
}
