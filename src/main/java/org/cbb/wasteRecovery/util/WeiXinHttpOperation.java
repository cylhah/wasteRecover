package org.cbb.wasteRecovery.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cbb.wasteRecovery.entity.weixin.button.Button;
import org.cbb.wasteRecovery.entity.weixin.button.Menu;
import org.cbb.wasteRecovery.entity.weixin.button.ViewButton;
import org.cbb.wasteRecovery.enums.weixin.ButtonType;

import java.io.IOException;

public class WeiXinHttpOperation {
    public static final String APPID="wx6ef3f5bd2ef0dbe3";
    public static final String APPSECRET="ac07925719aae619ba571c8b746cfbf6";

    public static final String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
    public static final String CALLBACK_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE&state=STATE#wechat_redirect";

    public static JSONObject doGet(String url){
        SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
        DefaultHttpClient httpClient=new DefaultHttpClient();
        HttpGet httpGet=new HttpGet(url);

        JSONObject jsonpObject=null;
        try {
            HttpResponse response=httpClient.execute(httpGet);
            HttpEntity entity=response.getEntity();
            if(entity!=null){
                String result=EntityUtils.toString(entity,"UTF-8");
                jsonpObject=JSONObject.fromObject(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonpObject;
    }

    public static JSONObject doPost(String url,String outStr){
        SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
        DefaultHttpClient httpClient=new DefaultHttpClient();
        HttpPost httpPost=new HttpPost(url);

        JSONObject jsonpObject=null;
        try {
            httpPost.setEntity(new StringEntity(outStr,"UTF-8"));
            HttpResponse response=httpClient.execute(httpPost);
            HttpEntity entity=response.getEntity();
            if(entity!=null){
                String result=EntityUtils.toString(entity,"UTF-8");
                jsonpObject=JSONObject.fromObject(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonpObject;
    }


    public static int createMenu(String token,String menu){
        int result=0;
        String tempUrl=CREATE_MENU_URL.replace("ACCESS_TOKEN",token);
        JSONObject jsonObject=doPost(tempUrl,menu);
        if(jsonObject!=null){
            result=jsonObject.getInt("errcode");
        }
        return result;
    }

    public static Menu initMenu(){
        String baseUrl=WeiXinHttpOperation.CALLBACK_URL;
        String furUrl=baseUrl.replace("APPID",APPID).
                replace("REDIRECT_URI","http%3A%2F%2Fcw22nq.natappfree.cc%2Fuser%2Flogin").
                replace("SCOPE","snsapi_base");
        Menu menu=new Menu();
        ViewButton viewButton=new ViewButton();
        viewButton.setType(ButtonType.VIEW.getTypeName());
        viewButton.setName("我要下单");
        viewButton.setUrl(furUrl);

        ViewButton viewButton2=new ViewButton();
        viewButton2.setType(ButtonType.VIEW.getTypeName());
        viewButton2.setName("我要接单");
        viewButton2.setUrl(furUrl.replace("user","collector"));
        menu.setButton(new Button[]{viewButton,viewButton2});
        return menu;
    }
}
