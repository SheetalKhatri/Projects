package com.prestige.postalhmis.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String getHomePage() {
        return "homePage";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "loginPage";
    }
}
