package org.cbb.wasteRecovery.controller;

import org.cbb.wasteRecovery.bean.User;
import org.cbb.wasteRecovery.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model, HttpSession session){
        User fuser=(User) session.getAttribute("user");
        if(fuser!=null) return "client";
        String code=request.getParameter("code");
        if(code==null||code.equals(""))
            return "client";//调试
        System.out.println(code);
        User user=loginService.userLogin(code);
        model.addAttribute("user",user);
        return "client";
    }
}
