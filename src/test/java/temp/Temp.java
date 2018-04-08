package temp;

import org.junit.Test;

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
}
