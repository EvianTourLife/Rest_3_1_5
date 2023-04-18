package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl service;

    public AdminController(UserServiceImpl service) {
        this.service = service;
    }
//    @GetMapping("/getAll")
//    public String getAdminPage(Model model, @AuthenticationPrincipal User user) {
//        model.addAttribute("user", user);
//        model.addAttribute("allRoles", service.getAllRoles());
//        model.addAttribute("users", service.getAll());
//        return "/index";
//    }

    @GetMapping("/getAll")
    public List<User> getAdminPage() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public User getUserInfo(@PathVariable Long id) {
        return service.getById(id);
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
