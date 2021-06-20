package com.sda.traianszabi.onlinelibrary.config;


import com.sda.traianszabi.onlinelibrary.model.User;
import com.sda.traianszabi.onlinelibrary.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserControl {
    private final UserService userService;

    public UserControl(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (userService.userExists(user.getLogin())) {
            return ResponseEntity.badRequest().build();
        }
        userService.createUser(user);
        return ResponseEntity.ok("User succesfully created , you are the best progrmammer !");
    }
}
