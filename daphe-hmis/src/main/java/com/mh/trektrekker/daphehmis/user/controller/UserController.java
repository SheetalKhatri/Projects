package com.mh.trektrekker.daphehmis.user.controller;

import com.mh.trektrekker.daphehmis.enums.UserType;
import com.mh.trektrekker.daphehmis.user.entity.User;
import com.mh.trektrekker.daphehmis.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getWelcomePage(ModelMap map) {
        map.put("userTypes", UserType.values());
        map.put("users",userService.findUsers());
        return "welcome";
    }

    @PostMapping("/")
    public String getRegisterUser(@ModelAttribute("user") User potato) {
        userService.save(potato);
        return "redirect:/";
    }
}
