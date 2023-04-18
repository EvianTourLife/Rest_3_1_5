//package com.example.bssecurity_3_1_4.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//public class HelloController {
//
//    @GetMapping("/login")
//    public String login(@RequestParam(value = "error",required = false)String error,
//                        @RequestParam(value = "logout",required = false)String logout,
//                        Model model) {
//        model.addAttribute("error", error!=null);
//        model.addAttribute("error", logout!=null);
//        return "login";
//    }
//}
