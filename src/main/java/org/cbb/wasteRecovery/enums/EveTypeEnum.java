package org.cbb.wasteRecovery.enums;

public enum EveTypeEnum {
    SUBSCRIBE("subscribe",""),
    SCAN("scan",""),
    LOCATION("location",""),
    CLICK("click",""),
    VIEW("view","");

    private String type;
    private String methodName;

    EveTypeEnum(String type, String methodName) {
        this.type = type;
        this.methodName = methodName;
    }

    public String getType() {
        return type;
    }

    public String getMethodName() {
        return methodName;
    }
}
