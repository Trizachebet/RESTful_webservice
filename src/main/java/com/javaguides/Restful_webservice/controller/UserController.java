package com.javaguides.Restful_webservice.controller;

import com.javaguides.Restful_webservice.dto.UserDto;
import com.javaguides.Restful_webservice.entity.User;
import com.javaguides.Restful_webservice.service.UserService;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")

public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user ){
        UserDto savedUser= userService.CreateUser(user);
        return new ResponseEntity<>(savedUser , HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public  ResponseEntity<UserDto> findUserByid(@PathVariable("id") Long userid){
       UserDto user= userService.getUserByidd(userid);
       return new ResponseEntity<> (user, HttpStatus.OK);
    }
    @GetMapping
    public  ResponseEntity<List<UserDto>> findAll(User user){
        List<UserDto> users=userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<User> updateByid(@PathVariable("id") Long userid,
                                           @RequestBody User user){
        user.setId(userid);
            User updateduser=userService.updateUserByid(user);
            return new ResponseEntity<>(updateduser,HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteByid(@PathVariable("id") Long userid){
       userService.deleteByid(userid);
       return new ResponseEntity<>("Deletion successful",HttpStatus.OK);
    }

}
