package org.cbb.wasteRecovery.entity.weixin;

import net.sf.json.JSONObject;
import org.cbb.wasteRecovery.util.WeiXinHttpOperation;


public class AccessToken {
    private String code;
    private long getTime;
    private final long DURATION =7200*1000;
    private static final String ACCESS_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private final String GRANTTYPE ="client_credential";
    private static AccessToken access_token=null;

    public static AccessToken getAccess_token(){
        if(access_token==null)
            return access_token=new AccessToken();
        else{
            if(System.currentTimeMillis()<access_token.getTime+access_token.DURATION)
                return access_token;
            else
                return access_token=new AccessToken();
        }
    }
    private AccessToken(){
        getTime=System.currentTimeMillis();
        String url=ACCESS_TOKEN_URL.replace("APPID",WeiXinHttpOperation.APPID).replace("APPSECRET",WeiXinHttpOperation.APPSECRET);
        JSONObject jsonObject= WeiXinHttpOperation.doGet(url);
        System.out.println(jsonObject);
        code=jsonObject.getString("access_token");
    }

    public String getCode() {
        return code;
    }

    public long getGetTime() {
        return getTime;
    }
}
