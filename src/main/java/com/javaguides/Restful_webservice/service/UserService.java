package com.javaguides.Restful_webservice.service;

import com.javaguides.Restful_webservice.entity.User;

import java.util.List;

public interface UserService {
    User CreateUser(User user );
    User getUserByidd(Long userid);
    List<User> getAllUsers();
    User updateUserByid(User user);
    public void deleteByid(Long userid);





}
