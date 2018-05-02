package org.cbb.wasteRecovery.enums;

import org.cbb.wasteRecovery.controller.WeiXinController;

import java.util.function.Function;

public enum MesTypeEnum {

    TEXT("text", WeiXinController.weiXinInteractService::TextReply,"TextMessage"),;
//    IMAGE("image","",""),
//    VOICE("voice","",""),
//    VIDEO("video","",""),
//    SHORT_VIDEO("shortvideo","",""),
//    LOCATION("location","",""),
//    LINK("link","",""),
//    EVENT("event","","");

    private String type;
    private String className;
    private Function<Object,Object> function;

    private final String packageName="org.cbb.wasteRecovery.entity.weixin.";

    MesTypeEnum(String type,Function<Object,Object> function,String className) {
        this.type = type;
        this.function=function;
        this.className=packageName+className;
    }

    public String getType() {
        return type;
    }

    public String getClassName() {
        return className;
    }

    public Object invoke(Object obj){
       return function.apply(obj);
    }
}
