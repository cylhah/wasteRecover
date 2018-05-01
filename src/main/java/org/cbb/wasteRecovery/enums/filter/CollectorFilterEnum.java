package org.cbb.wasteRecovery.enums.filter;

public enum CollectorFilterEnum implements FilterEnum{
    NAME("realName","realName"),
    PHONE_NUMBER("phoneNumber","phoneNumber"),
    IDCARD_NUM("idCardNum","idCardNum"),;

    private String column;
    private String field;

    private String alias="c.";

    CollectorFilterEnum(String column, String field) {
        this.column = alias+column;
        this.field = field;
    }

    public String getColumn() {
        return column;
    }

    public String getField() {
        return field;
    }
}
