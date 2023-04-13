package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.service.UserService;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserServiceImpl service) {
        this.service = service;
    }
    @GetMapping()
    public String showUserInfo(Model model, Principal principal) {
        model.addAttribute("user", service.findByUsername(
                principal.getName()).get());
        return "userInfo";
    }
}
