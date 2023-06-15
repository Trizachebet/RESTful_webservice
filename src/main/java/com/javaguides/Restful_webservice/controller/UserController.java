package com.javaguides.Restful_webservice.controller;

import com.javaguides.Restful_webservice.entity.User;
import com.javaguides.Restful_webservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")

public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user ){
        User savedUser= userService.CreateUser(user);
        return new ResponseEntity<>(savedUser , HttpStatus.CREATED);
    }
}
