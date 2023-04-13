package com.example.bssecurity_3_1_4.controllers;

import com.example.bssecurity_3_1_4.model.User;
import com.example.bssecurity_3_1_4.service.UserService;
import com.example.bssecurity_3_1_4.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.annotation.security.RolesAllowed;
import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService service;

    public AdminController(UserServiceImpl service) {
        this.service = service;
    }
    @GetMapping("/getAll")
    public String show(Model model, Principal principal) {
        model.addAttribute("user", service.findByUsername(
                principal.getName()).get());
        model.addAttribute("users", service.getAll());
        return "/index";
    }

//    @GetMapping("/getAll")
//    public String show(Model model) {
//        model.addAttribute("users", service.getAll());
//        return "/index";
//    }
    @GetMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        return "add";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") @Valid User user,  BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "add";
        }
        service.addUser(user);
        return "redirect:/admin/getAll";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam(value = "id", required = false) Long id) {
        model.addAttribute("user", service.getById(id));
        return "edit";
    }

    @PostMapping("/edit")
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
