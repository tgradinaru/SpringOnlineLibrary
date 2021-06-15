package com.sda.traianszabi.onlinelibrary.controller;


import com.sda.traianszabi.onlinelibrary.model.User;
import com.sda.traianszabi.onlinelibrary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public ResponseEntity<String> createUser(@RequestBody User user){
        if(userService.userExists(user.getLogin())){
            return ResponseEntity.badRequest().build();
        }
        userService.createUser(user);
        return ResponseEntity.ok("Dude, User successfully created!");
    }
}
