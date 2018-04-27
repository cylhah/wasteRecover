package org.cbb.wasteRecovery.enums;

public enum WeightStateEnum {
    ;
    private int state;
    private double value;

    WeightStateEnum(int state, double info) {
        this.state = state;
        this.value = info;
    }

    public int getState() {
        return state;
    }

    public double getValue() {
        return value;
    }

    public static WeightStateEnum stateof(int index){
        for (WeightStateEnum weightStateEnum:values()
             ) {
            if(weightStateEnum.getState()==index)
                return weightStateEnum;
        }
        return null;
    }

    public static WeightStateEnum valueof(double value){
        for (WeightStateEnum weightStateEnum:
             values()) {
            if(weightStateEnum.getValue()-value<1e-6)
                return weightStateEnum;
        }
        return null;
    }
}
