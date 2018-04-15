package org.cbb.wasteRecovery.exception;

public class ComplRepeatException extends CompleteOrderException {
    public ComplRepeatException(String s){
        super(s);
    }
    public ComplRepeatException(String s,Throwable throwable){
        super(s,throwable);
    }
}
