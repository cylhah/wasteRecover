package temp;

import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.bean.Scrap;
import org.cbb.wasteRecovery.entity.weixin.Message;
import org.cbb.wasteRecovery.entity.weixin.TextMessage;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Pattern;

public class Temp {
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
         Class myclass= Class.forName("org.cbb.wasteRecovery.entity.weixin.TextMessage");
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
    }
}
