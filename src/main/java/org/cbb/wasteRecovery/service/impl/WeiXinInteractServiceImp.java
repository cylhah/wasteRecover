package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.algorithm.encrypt.EnAlgorithm;
import org.cbb.wasteRecovery.algorithm.encrypt.SHA1;
import org.cbb.wasteRecovery.service.WeiXinInteractService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class WeiXinInteractServiceImp implements WeiXinInteractService {
    private final String token="code_monkey";

    public boolean checkSignature(String signature,String timestamp,String nonce){
        String[] arr=new String[]{token,timestamp,nonce};
        Arrays.sort(arr);

        StringBuffer stringBuffer=new StringBuffer();
        for(String s:arr){
            stringBuffer.append(s);
        }
        String sh1String=getcode(stringBuffer,new SHA1());
        return sh1String.equals(signature);
    }

    private String getcode(StringBuffer stringBuffer, EnAlgorithm enAlgorithm){
        return enAlgorithm.encode(stringBuffer.toString());
    }
}
