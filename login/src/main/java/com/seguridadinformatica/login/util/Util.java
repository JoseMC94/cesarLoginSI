package com.seguridadinformatica.login.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Util {
    public static void main(String[] args) {


       // @PreAuthorize("hasRole('ROLE_USER')")


        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        System.out.println(pe.encode("user"));
        System.out.println(pe.encode("admin"));
    }
}
