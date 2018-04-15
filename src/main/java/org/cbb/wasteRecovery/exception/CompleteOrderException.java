package org.cbb.wasteRecovery.exception;

public class CompleteOrderException extends RuntimeException {
    public CompleteOrderException(String s){
        super(s);
    }
    public CompleteOrderException(String s,Throwable throwable){
        super(s,throwable);
    }
}
