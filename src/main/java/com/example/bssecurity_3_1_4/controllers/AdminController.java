package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl service;

    public AdminController(UserServiceImpl service) {
        this.service = service;
    }
    @GetMapping("/getAll")
    public String show(Model model, Principal principal) {
        User user = (User) service.loadUserByUsername(principal.getName());
        model.addAttribute("user", service.getById(user.getId()));
        model.addAttribute("allRoles", service.getAllRoles());
        model.addAttribute("users", service.getAll());
        return "/index";
    }


    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user) {
        service.addUser(user);
        return "redirect:/admin/getAll";
    }

    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("user") User user) {
        service.edit(user);
        return "redirect:/admin/getAll";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id", required = false) Long id) {
        service.delete(id);
        return "redirect:/admin/getAll";
    }

}
