package com.mycompany.messaging.controller;

import com.mycompany.messaging.model.User;
import com.mycompany.messaging.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Returns the login view name
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User()); // Add a new User object to the model
        return "register"; // Returns the register view name
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model, RedirectAttributes redirectAttributes) {
        try {
            userService.registerUser(user); // Attempt to register the user
            redirectAttributes.addFlashAttribute("success", "Registration successful! Please log in."); // Flash success message
            return "redirect:/login"; // Redirect to login page with success message
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Registration failed: " + e.getMessage()); // Flash error message
            return "redirect:/register"; // Redirect back to the registration page with error message
        }
    }
}
