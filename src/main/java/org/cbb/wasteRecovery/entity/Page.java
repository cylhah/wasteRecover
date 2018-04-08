package org.cbb.wasteRecovery.entity;

public class Page {
    private int number;
    private int totalNum;
    private int currentPageNum;
    private int totalPageNum;

    public Page(){
        currentPageNum=1;
        number =10;
    }
    public Page(int limit) {
        this.number = limit;
        currentPageNum=1;
    }

    public int getNumber() {
        return number;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        if(currentPageNum>totalPageNum)
            this.currentPageNum=totalPageNum;
        else if(currentPageNum<=0)
            this.currentPageNum=1;
        else
            this.currentPageNum = currentPageNum;

    }

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public int count(){
        if(totalNum% number !=0){
            return  totalPageNum=totalNum/ number +1;
        }
        else
            return totalPageNum=totalNum/ number;
    }

}
