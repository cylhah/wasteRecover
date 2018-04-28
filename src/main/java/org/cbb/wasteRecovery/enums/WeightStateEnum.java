package org.cbb.wasteRecovery.enums;

public enum WeightStateEnum {
    LIGHT(1,"1kg");
    private int state;
    private String info;

    WeightStateEnum(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public static WeightStateEnum stateof(int index){
        for (WeightStateEnum weightStateEnum:values()
             ) {
            if(weightStateEnum.getState()==index)
                return weightStateEnum;
        }
        return null;
    }

    public static WeightStateEnum valueof(String info){
        for (WeightStateEnum weightStateEnum:
             values()) {
            if(weightStateEnum.getInfo().equals(info))
                return weightStateEnum;
        }
        return null;
    }
}
