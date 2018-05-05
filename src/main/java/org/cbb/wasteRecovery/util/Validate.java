package org.cbb.wasteRecovery.util;

import org.cbb.wasteRecovery.bean.Orderform;
import org.cbb.wasteRecovery.bean.ScrapMessage;

import java.util.regex.Pattern;

public class Validate {
    private static Pattern intPattern =Pattern.compile("[0-9]{1,10}");
    private static Pattern longPattern=Pattern.compile("[0-9]{1,20}");
    private static Pattern TimePattern =Pattern.compile("[0-9|\\.|\\-|:| ]{1,30}");
    private static Pattern DoublePattern=Pattern.compile("[0-9|\\.]{1,15}");
    public static boolean validateSubmitOrder(Orderform orderform){
        if(orderform==null) return false;

        if (!myMatch(intPattern,orderform.getAid())||!myMatch(intPattern,orderform.getUid()))
            return false;
        if(!myMatch(TimePattern,String.valueOf(orderform.getAppointTime())))
            return false;
        return true;
    }
    public static boolean validateComplOrder(Orderform orderform){
        if(orderform.getScrapMessageList().size()==0) return false;
//        if(!myMatch(DoublePattern,String.valueOf(orderform.getWeight()))) return false;
//        if(!myMatch(DoublePattern,String.valueOf(orderform.getPrice()))) return false;
        for(ScrapMessage scrapMessage:orderform.getScrapMessageList()){
            if(!myMatch(intPattern,scrapMessage.getScrapid()))
                return false;
            if(!myMatch(DoublePattern,scrapMessage.getWeight())||!myMatch(DoublePattern,scrapMessage.getPrice()))
                return false;
        }
        return true;
    }

    private static boolean myMatch(Pattern pattern,Object data){
        String s=String.valueOf(data);
        if(data==null||!pattern.matcher(s).matches())
            return false;
        return true;
    }
}
