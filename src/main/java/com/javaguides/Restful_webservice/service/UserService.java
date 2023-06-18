package com.javaguides.Restful_webservice.service;

import com.javaguides.Restful_webservice.dto.UserDto;
import com.javaguides.Restful_webservice.entity.User;

import java.util.List;

public interface UserService {
    UserDto CreateUser(UserDto user );
    UserDto getUserByidd(Long userid);
    List<UserDto> getAllUsers();
    User updateUserByid(User user);
    public void deleteByid(Long userid);





}
