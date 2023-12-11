package com.dmadev.restapp.controller;

import com.dmadev.restapp.exception.UserAlreadyExistException;
import com.dmadev.restapp.exception.UserNotFoundException;
import com.dmadev.restapp.model.User;
import com.dmadev.restapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) throws UserAlreadyExistException {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) throws UserNotFoundException {
        if (userService.getUserById(id) == null) {
            throw new UserNotFoundException("User with id:" + id + "not found");
        }
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") Long id) throws UserAlreadyExistException {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) throws UserNotFoundException {
        if (userService.getUserById(id) == null) {
            throw new UserNotFoundException("User with id:" + id + "not found");
        }
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
