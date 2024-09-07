package org.example.springbootcrud.controller;


import org.example.springbootcrud.model.User;
import org.example.springbootcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users";
    }

    @GetMapping("/user-form")
    public String showUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("action", "add");
        return "user-form";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @PostMapping("/user-form-update")
    public String showUserFormUpdate(@RequestParam("userId") Long userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        model.addAttribute("action", "update");
        return "user-form";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
       userService.update(user);
        return "redirect:/users";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("userId") Long userId) {
        userService.delete(userId);
        return "redirect:/users";
    }

}
