package org.cbb.wasteRecovery.controller;

import org.cbb.wasteRecovery.enums.weixin.MesTypeEnum;
import org.cbb.wasteRecovery.util.MessageTransfer;
import org.cbb.wasteRecovery.service.WeiXinInteractService;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/weixin")
public class WeiXinController {
    public static WeiXinInteractService weiXinInteractService;

    @Autowired
    public void setWeiXinInteractService(WeiXinInteractService weiXinInteractService){
        WeiXinController.weiXinInteractService=weiXinInteractService;
    }

    @RequestMapping(value = "",method = RequestMethod.GET)
    public void buttJoint(HttpServletRequest request, HttpServletResponse response)throws IOException  {
        String signature=request.getParameter("signature");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String echostr=request.getParameter("echostr");

        List<String> alls=new ArrayList<String>();
        alls.add(signature);
        alls.add(timestamp);
        alls.add(nonce);
        alls.add(echostr);

        PrintWriter printWriter= response.getWriter();
        for(String s:alls) {
            if (s == null || s.equals("")) {
                printWriter.println("get存在空值");
                return;
            }
        }

        if(weiXinInteractService.checkSignature(signature,timestamp,nonce))
            printWriter.print(echostr);

        return;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public void interact(HttpServletRequest request,HttpServletResponse response) throws IOException, DocumentException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Map<String,String> msg=MessageTransfer.xmlToMap(request);
        Object obj=MessageTransfer.mapObj(msg);
        for(MesTypeEnum typeEnum:MesTypeEnum.values()){
            if(msg.get("MsgType").equals(typeEnum.getType())){
                Object temp=typeEnum.invoke(obj);
                String reply=MessageTransfer.MessToXml(temp);
                PrintWriter printWriter=response.getWriter();
                printWriter.print(reply);
                break;
            }
        }

        return;
    }


}
