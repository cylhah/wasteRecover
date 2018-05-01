package org.cbb.wasteRecovery.enums.filter.util;

import org.cbb.wasteRecovery.enums.filter.FilterEnum;

public enum ScrapFilterEnum implements FilterEnum {
    ID("id","id"),
    TYPE_NAME("typeName","typeName"),
    NAME("name","name"),
    UNIT_PRICE("unitPrice","unitPrice"),
    ;

    private String column;
    private String field;

    ScrapFilterEnum(String column, String field) {
        this.column =column;
        this.field = field;
    }

    public String getColumn() {
        return column;
    }

    public String getField() {
        return field;
    }
}
