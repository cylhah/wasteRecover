package org.cbb.wasteRecovery.service;

import org.springframework.stereotype.Service;

@Service
public interface WeiXinInteractService {
    /**
     * 校验密文
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    boolean checkSignature(String signature,String timestamp,String nonce);

    /**
     * 获得自动回复信息
     * @param textMessage
     * @return
     */
    Object TextReply(Object textMessage);


}
