package org.cbb.wasteRecovery.entity;

import java.util.List;

public class PageList {
    private Page page;
    private List list;

    public PageList(Page page, List list) {
        this.page = page;
        this.list = list;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
