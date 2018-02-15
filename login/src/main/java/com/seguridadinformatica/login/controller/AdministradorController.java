package com.seguridadinformatica.login.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdministradorController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/administrador")
    public String index(){
        return "Administrador";
    }

}
