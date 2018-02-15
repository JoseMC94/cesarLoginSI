package com.seguridadinformatica.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    @GetMapping("/")
    public String home(){
        return "login";
    }


    @GetMapping("/login")
    public String showLoginForm(Model model,
                                @RequestParam(name = "error", required = false) String error,
                                @RequestParam(name = "logout", required = false) String logout){
        model.addAttribute("error", error);
        model.addAttribute("logout",logout);
        //return  ViewConstant.LOGIN;
        return  "login";
    }

    @GetMapping({"/loginsucces"})
    public String loginCheck(){
        return "redirect:/home";
    }
}
