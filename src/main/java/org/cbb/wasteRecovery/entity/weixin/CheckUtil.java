package org.cbb.wasteRecovery.entity.weixin;

import org.cbb.wasteRecovery.entity.encrypt.EnAlgorithm;
import org.cbb.wasteRecovery.entity.encrypt.SHA1;

import java.util.Arrays;

public class CheckUtil {
    private static final String token="code_monkey";

    public static boolean checkSignature(String signature,String timestamp,String nonce){
        String[] arr=new String[]{token,timestamp,nonce};
        Arrays.sort(arr);

        StringBuffer stringBuffer=new StringBuffer();
        for(String s:arr){
            stringBuffer.append(s);
        }
        String sh1String=getcode(stringBuffer,new SHA1());
        return sh1String.equals(signature);
    }

    private static String getcode(StringBuffer stringBuffer, EnAlgorithm enAlgorithm){
        return enAlgorithm.encode(stringBuffer.toString());
    }
}
