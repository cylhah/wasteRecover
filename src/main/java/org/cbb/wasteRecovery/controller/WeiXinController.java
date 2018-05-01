package org.cbb.wasteRecovery.controller;

import org.cbb.wasteRecovery.entity.weixin.CheckUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/weixin")
public class WeiXinController {
    @RequestMapping(value = "/buttJoint",method = RequestMethod.GET)
    public void buttJoint(HttpServletRequest request, HttpServletResponse response)  {
        String signature=request.getParameter("signature");
        String timestamp=request.getParameter("timestamp");
        String nonce=request.getParameter("nonce");
        String echostr=request.getParameter("echostr");

        PrintWriter printWriter= null;
        try {
            printWriter = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(CheckUtil.checkSignature(signature,timestamp,nonce))
            printWriter.print(echostr);

        return;
    }
}
