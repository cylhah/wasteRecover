package org.cbb.wasteRecovery.service.impl;

import net.sf.json.JSONObject;
import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.bean.Consultant;
import org.cbb.wasteRecovery.bean.User;
import org.cbb.wasteRecovery.dao.CollectorDao;
import org.cbb.wasteRecovery.dao.ConsultantDao;
import org.cbb.wasteRecovery.dao.UserDao;
import org.cbb.wasteRecovery.service.LoginService;
import org.cbb.wasteRecovery.util.WeiXinHttpOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImp implements LoginService {
    private final String GETOPENID_URL ="https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";

    @Autowired
    private UserDao userDao;

    @Autowired
    private CollectorDao collectorDao;

    @Autowired
    private ConsultantDao consultantDao;

    private String getOpenid(String code){
        String realUrl= GETOPENID_URL.replace("APPID",WeiXinHttpOperation.APPID).replace
                ("SECRET",WeiXinHttpOperation.APPSECRET).replace("CODE",code);
        JSONObject jsonObject=WeiXinHttpOperation.doGet(realUrl);
        return jsonObject.getString("openid");
    }

    public User userLogin(String code) {
        String openid=getOpenid(code);
        User user;
        if(openid.equals("")||openid==null)
            return null;
        if((user=userDao.selectById(openid))==null) {
            userDao.insertUser(openid);
            return userDao.selectById(openid);
        }
        return user;
    }

    public Collector collectorLogin(String phoneNumber, String password,String openid) {
        if(phoneNumber.equals("")||password.equals("")||phoneNumber==null||password==null)
            return null;
        Collector collector= collectorDao.selectByPhoneNumAndPass(phoneNumber,password);
        if (collector==null) return null;

        Map constrains=new HashMap();
        constrains.put("openid",openid);
        if (collector.getOpenid().equals("")||collector.getOpenid()==null)
            collectorDao.updateData(collector.getId(),constrains);
        return collector;

    }

    public Collector collectorLogin(String code) {
        String openid=getOpenid(code);
        if(openid==null||openid.equals(""))
            return null;
        return collectorDao.selectByOpenid(openid);
    }


    public Consultant consultantLogin(String username, String password) {
        if(username.equals("")||password.equals("")||username==null||password==null)
            return null;
        return consultantDao.selectByUsernameAndPass(username,password);
    }

    public boolean consultantSignOut(HttpSession httpSession) {
        return false;
    }


}
