package com.thoughtworks.capacity.gtb.mvc.controller;

import com.thoughtworks.capacity.gtb.mvc.model.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //GET /users
    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //GET /login
    @GetMapping(value = "/login")
    public List<User> getUserInfo(@RequestParam(name = "username") @Valid String username, @RequestParam(name = "password") @Valid String password) {
        return userService.getUserInfo(username, password);
    }

    //POST /users
    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody @Valid User user) {
        userService.createUser(user);
    }
}
