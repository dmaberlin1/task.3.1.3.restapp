package com.dmadev.restapp.controller;

import com.dmadev.restapp.exception.UserAlreadyExistException;
import com.dmadev.restapp.model.User;
import com.dmadev.restapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class MyRestController {
    private final UserService userService;

    @GetMapping("/users")
    public List<User> allUsers(){
        List<User>users=userService.getAllUsers();
        return users;
    }

    @PostMapping("/new")
    public User addUser(@RequestBody User user) throws UserAlreadyExistException {
        userService.saveUser(user);
        return user;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") long id){
        userService.deleteUser(id);
    }


}
