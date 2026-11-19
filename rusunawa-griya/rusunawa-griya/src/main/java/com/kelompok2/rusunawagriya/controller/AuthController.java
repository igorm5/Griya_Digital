package com.kelompok2.rusunawagriya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/")
    public String index() {
        // Arahkan halaman utama ke katalog penghuni
        return "redirect:/penghuni/katalog";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "penghuni/login";
    }
}
