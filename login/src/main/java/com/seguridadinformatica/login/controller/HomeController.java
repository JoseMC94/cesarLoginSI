package com.seguridadinformatica.login.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView model = new ModelAndView("home");
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addObject("user",user.getUsername());
        return model;
    }


}
