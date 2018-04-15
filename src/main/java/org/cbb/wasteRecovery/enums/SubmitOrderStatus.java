package org.cbb.wasteRecovery.enums;

public enum SubmitOrderStatus {
    SUCCESS(1,"提交成功"),
    REPEAT_SUBMIT(0,"重复提交"),
    FORMAT_EXCEPRION(-1,"格式异常"),
    INNER_ERR0(-2,"服务器异常");

    private int state;
    private String info;

    SubmitOrderStatus(int state, String info) {
        this.state = state;
        this.info = info;
    }

    public int getState() {
        return state;
    }

    public String getInfo() {
        return info;
    }

    public static SubmitOrderStatus stateof(int index){
        for(SubmitOrderStatus state:values()){
            if (state.getState()==index)
                return state;
        }
        return null;
    }
}
