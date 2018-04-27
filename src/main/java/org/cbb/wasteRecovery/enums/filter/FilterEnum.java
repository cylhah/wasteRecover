package org.cbb.wasteRecovery.enums.filter;

public interface FilterEnum {
    /**
     * 获得筛选列名
     * @return
     */
    String getColumn();

    /**
     * 获得筛选对应的属性名
     * @return
     */
    String getField();
}
