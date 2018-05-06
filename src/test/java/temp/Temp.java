package temp;

import net.sf.json.JSONObject;
import org.cbb.wasteRecovery.bean.Scrap;
import org.cbb.wasteRecovery.entity.weixin.AccessToken;
import org.cbb.wasteRecovery.entity.weixin.Data;
import org.cbb.wasteRecovery.entity.weixin.TpMess;
import org.cbb.wasteRecovery.entity.weixin.mess.Message;
import org.cbb.wasteRecovery.entity.weixin.button.Menu;
import org.cbb.wasteRecovery.util.WeiXinHttpOperation;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Temp {

    private String accesstoken="9_LfYwUSJTX5f2BX-GRmpntitJXGeal2l6TLqiRHjj42wOHLxiu9oGQUks9RnaxU0qrWssKRuOHsGShxn5Iae65s6iKzHQhmJ-uV8j9ofAZ5jb93gIuSLlrj0UOiV8wxswZHqHP3m_mP7fFahpWTAbADADAH";
    private String userloginUrl="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx6ef3f5bd2ef0dbe3&redirect_uri=http%3A%2F%2Fswcmc6.natappfree.cc%2Fuser%2Flogin&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
    private String collLoginUrl=userloginUrl.replace("user","collector");
    @Test
    public void TestPatter(){
        Pattern pattern2=Pattern.compile("[0-9]{1,9}");
        int s=123;
        String s2=new String();
        s2=String.valueOf(new Timestamp(new Date().getTime()));
        System.out.println(s2);
        System.out.println(pattern2.matcher(s2).matches());
        System.out.println(111);
    }

    @Test
    public void testnull(){
        Scrap scrap=new Scrap();
        System.out.println(scrap.getUnitPrice()==null);
    }

    @Test
    public void testReflect() throws ClassNotFoundException {
         Class myclass= Class.forName("org.cbb.wasteRecovery.entity.weixin.mess.TextMessage");
         Class superclass=myclass.getSuperclass();
         Class bigsuper=superclass.getSuperclass();
         System.out.println(bigsuper.getSimpleName());
         Field[] fields=myclass.getDeclaredFields();
         Field[] superfiellds=superclass.getDeclaredFields();

         for(Field field:superfiellds){
             System.out.println(field.getName());
         }
         for(Field field:fields){
             System.out.println(field.getName());
         }
    }

    @Test
    public void testParentTransfer(){
//        Message message = new Message();
//        Class clazz=((TextMessage)message).getClass();
//        Field[] fields=clazz.getDeclaredFields();
//        for(Field field:fields){
//            System.out.println(field.getName());
//        }
        Object obj=new Message();
        Message message=(Message)obj;
       System.out.println(obj.getClass());
    }

    @Test
    public void timeTest(){
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date().getTime());
        System.out.println(System.currentTimeMillis()==new Date().getTime());
    }

    @Test
    public void stringTest(){
        System.out.println("asd"+"asd");
        System.out.println("asd".hashCode());
        System.out.println("asd".getClass());
        System.out.println(String.class);
    }

    @Test
    public void AccessTokenTest() {
        AccessToken accessToken=AccessToken.getAccess_token();
    }

    @Test
    public void ButtonTest()  {
        Menu menu=WeiXinHttpOperation.initMenu();
        String s=JSONObject.fromObject(menu).toString();
        System.out.println(s);
        int i=WeiXinHttpOperation.createMenu(accesstoken,s);
        System.out.println(i);
    }

    @Test
    public void templateTest(){
        TpMess tpMess=new TpMess();
        tpMess.setTemplate_id("GQgs-O30lhBN5SnkcDWOlbPYTFsJQJAi6OQeIjDRcE0");
        tpMess.setTouser("oW7rD08VgL6Pvrz1Q9r4_NRqPMmg");
        tpMess.setUrl(userloginUrl);
        Map map=new HashMap();
        Data data=new Data();

        Data data1=new Data();
        data1.setValue("嘿嘿嘿");
        data1.setColor("#000000");
        Data data2=new Data();
        data2.setValue("张鑫");
        data2.setColor("#000000");
        Data data3=new Data();
        data3.setValue("衢州学院");
        data3.setColor("#000000");
        Data data4=new Data();
        data4.setValue("1375822228181");
        data4.setColor("#000000");

        map.put("keyword1",data1);
        map.put("keyword2",data2);
        map.put("keyword3",data3);
        map.put("keyword4",data4);
        tpMess.setData(map);

        System.out.println(JSONObject.fromObject(tpMess));

        String aurl="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",accesstoken);
        WeiXinHttpOperation.doPost(aurl,JSONObject.fromObject(tpMess).toString());
    }

}
