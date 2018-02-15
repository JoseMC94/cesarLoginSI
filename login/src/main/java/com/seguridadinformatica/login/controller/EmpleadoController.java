package com.seguridadinformatica.login.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadoController {

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/empleado")
    public String index(){
        return "Empleado";
    }
}
