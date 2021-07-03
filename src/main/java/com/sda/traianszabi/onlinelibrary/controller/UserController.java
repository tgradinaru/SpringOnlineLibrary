package com.sda.traianszabi.onlinelibrary.controller;


import com.sda.traianszabi.onlinelibrary.model.User;
import com.sda.traianszabi.onlinelibrary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (userService.userExist(user.getLogin())) {
            return ResponseEntity.badRequest().build();
        }
        userService.createUser(user);
        return ResponseEntity.ok("User successfully created , you are the best programmer !");
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

}
