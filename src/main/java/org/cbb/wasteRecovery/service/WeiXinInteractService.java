package org.cbb.wasteRecovery.service;

import org.springframework.stereotype.Service;

@Service
public interface WeiXinInteractService {
    /**
     * 校验密码
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    boolean checkSignature(String signature,String timestamp,String nonce);

    
}
