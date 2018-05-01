package org.cbb.wasteRecovery.enums.filter.util;

import org.cbb.wasteRecovery.enums.filter.FilterEnum;

public enum OrderFilterEnum implements FilterEnum {
    COLLECTOR("cid","cid"),
    UPDATETIME("updateTime","updateTime"),
    STATE("state","state"),
    USER("uid","uid"),
    COMMUNITY("cid","cid"),
    ;

    private String column;
    private String field;

    //别名
    private String alias="o.";

    OrderFilterEnum(String column, String field) {
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
