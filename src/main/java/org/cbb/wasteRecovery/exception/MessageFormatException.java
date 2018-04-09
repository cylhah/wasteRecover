package org.cbb.wasteRecovery.exception;

public class MessageFormatException extends CompleteOrderException {
    public MessageFormatException(String s){
        super(s);
    }
    public MessageFormatException(String s,Throwable throwable){
        super(s,throwable);
    }
}
