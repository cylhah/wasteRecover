package org.cbb.wasteRecovery.entity;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
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

    public static String textMessToXml (TextMessage textMessage){
        XStream xStream=new XStream();
        xStream.alias("xml",textMessage.getClass());
        return  xStream.toXML(textMessage);
    }
}
