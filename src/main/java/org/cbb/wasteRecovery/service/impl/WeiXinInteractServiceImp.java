package org.cbb.wasteRecovery.service.impl;

import org.cbb.wasteRecovery.algorithm.SHA1;
import org.cbb.wasteRecovery.entity.weixin.TextMessage;
import org.cbb.wasteRecovery.enums.MesTypeEnum;
import org.cbb.wasteRecovery.service.WeiXinInteractService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

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
        String sh1String=new SHA1().encode(stringBuffer.toString());
        return sh1String.equals(signature);
    }

    public Object TextReply(Object textMessage) {
        TextMessage from=(TextMessage)textMessage;
        TextMessage replay=new TextMessage();
        replay.setToUserName(from.getFromUserName());
        replay.setFromUserName(from.getToUserName());
        replay.setCreateTime(String.valueOf(new Date().getTime()));
        replay.setMsgType(MesTypeEnum.TEXT.getType());
        replay.setContent("服务器已收到您的消息: "+from.getContent());
        return replay;
    }


}
