package org.cbb.wasteRecovery.controller;

import org.cbb.wasteRecovery.bean.Collector;
import org.cbb.wasteRecovery.service.LoginService;
import org.cbb.wasteRecovery.service.SelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/collector")
@SessionAttributes("collector")
public class CollController {
    @Autowired
    SelectService selectService;

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model, HttpSession session){
        Collector fc=(Collector) session.getAttribute("collector");
        if(fc!=null) return "html/receiver.html";
        String code=request.getParameter("code");
        if(code==null||code.equals(""))
            return "WEB-INF/jsp/erro.jsp";
        Collector collector=loginService.collectorLogin(code);
        if(collector==null) return "WEB-INF/jsp/login.jsp";
        model.addAttribute("collector",collector);
        return "html/receiver.html";
    }
}
