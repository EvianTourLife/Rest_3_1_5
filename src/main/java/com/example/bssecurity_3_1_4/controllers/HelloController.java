package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {


//    @GetMapping("/")
//    public String homePage() {
//        return "redirect:/login";
//    }

//    @GetMapping("/")
//    public String login() {
//        return "login";
//    }
    @GetMapping("/login")
    public String login(@RequestParam(value = "error",required = false)String error,
                        @RequestParam(value = "logout",required = false)String logout,
                        Model model) {
        model.addAttribute("error", error!=null);
        model.addAttribute("error", logout!=null);
        return "login";
    }
}
