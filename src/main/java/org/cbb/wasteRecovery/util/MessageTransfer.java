package org.cbb.wasteRecovery.util;

import com.thoughtworks.xstream.XStream;
import org.cbb.wasteRecovery.enums.weixin.MesTypeEnum;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageTransfer {

    /**
     * xml转化为map
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String,String> map=new HashMap<String, String>();
        SAXReader reader=new SAXReader();

        InputStream inputStream=request.getInputStream();
        Document document=reader.read(inputStream);

        Element root=document.getRootElement();
        List<Element> elements=root.elements();

        for (Element element:elements) {
            map.put( element.getName(),element.getText());
        }
        inputStream.close();
        return map;
    }

    public static String MessToXml(Object message){
        XStream xStream=new XStream();
        xStream.alias("xml",message.getClass());
        System.out.println(xStream.toXML(message));
        return  xStream.toXML(message);
    }

    public static Object mapObj(Map<String,String> msg) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        for(MesTypeEnum typeEnum:MesTypeEnum.values()){
            if(msg.get("MsgType").equals(typeEnum.getType())) {
                List<Class> classes=new ArrayList<Class>();
                Class myclass=Class.forName(typeEnum.getClassName());
                while(!myclass.getSimpleName().equals("Object")){
                    classes.add(myclass);
                    myclass=myclass.getSuperclass();
                }
                Constructor constructor=classes.get(0).getConstructor();
                Object object=constructor.newInstance();
                for(Class clazz:classes){
                    Field[] fields=clazz.getDeclaredFields();
                    for(Field field:fields){
                        field.setAccessible(true);
                        field.set(object,msg.get(field.getName()));
                    }
                }
                return object;
            }
        }
        return null;
    }
}
