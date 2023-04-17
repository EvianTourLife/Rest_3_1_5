package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {


    @GetMapping()
    public String getUserInfo(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", user);
        return "userInfo";
    }
}
