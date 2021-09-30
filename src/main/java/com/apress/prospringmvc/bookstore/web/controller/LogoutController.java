package com.apress.prospringmvc.bookstore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.htm";
    }

}
