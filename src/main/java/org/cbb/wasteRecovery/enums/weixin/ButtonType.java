package org.cbb.wasteRecovery.enums.weixin;

public enum  ButtonType {
    CLICK("click"),
    VIEW("view"),;
    private String typeName;

    ButtonType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
