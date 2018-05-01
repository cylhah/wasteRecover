package org.cbb.wasteRecovery.controller;

import org.cbb.wasteRecovery.service.WeiXinInteractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/weixin")
public class WeiXinController {
    @Autowired
    WeiXinInteractService weiXinInteractService;

    @RequestMapping(value = "",method = RequestMethod.GET)
    public void buttJoint(HttpServletRequest request, HttpServletResponse response)  {
        String signature=request.getParameter("signature");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String echostr=request.getParameter("echostr");

        List<String> alls=new ArrayList<String>();
        alls.add(signature);
        alls.add(timestamp);
        alls.add(nonce);
        alls.add(echostr);

        PrintWriter printWriter= null;
        try {
            printWriter = response.getWriter();
            for(String s:alls){
                if(s==null||s.equals("")){
                    printWriter.println("get存在空值");
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(weiXinInteractService.checkSignature(signature,timestamp,nonce))
            printWriter.print(echostr);

        return;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public void interact(HttpServletRequest request,HttpServletResponse response){
        return;
    }
}
