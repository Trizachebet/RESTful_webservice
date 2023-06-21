package com.javaguides.Restful_webservice.controller;

import com.javaguides.Restful_webservice.dto.UserDto;
import com.javaguides.Restful_webservice.entity.User;
import com.javaguides.Restful_webservice.exception.ErrorDetail;
import com.javaguides.Restful_webservice.exception.ResourceNotFoundException;
import com.javaguides.Restful_webservice.service.UserService;
import jakarta.persistence.Id;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")

public class UserController {
    private UserService userService;
    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user ){
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
    public ResponseEntity<UserDto> updateByid(@PathVariable("id") Long userid,
                                           @RequestBody@Valid UserDto user){
        user.setId(userid);
            UserDto updatedUser=userService.updateUserByid(user);
            return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteByid(@PathVariable("id") Long userid){
       userService.deleteByid(userid);
       return new ResponseEntity<>("Deletion successful",HttpStatus.OK);
    }
    //Exception handler handles specific exceptions and returns response to client
   // @ExceptionHandler(ResourceNotFoundException.class)
    //public ResponseEntity<ErrorDetail> handlerResponseNotFound(ResourceNotFoundException exception, WebRequest webRequest ){
      //  ErrorDetail errorDetails = new ErrorDetail(
               // LocalDateTime.now(),
               // exception.getMessage(),
               // webRequest.getDescription(false),
                //"User_not_found"

  //  );

        //return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
   // }

}
