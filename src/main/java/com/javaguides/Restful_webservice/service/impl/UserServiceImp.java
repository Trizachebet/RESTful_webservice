package com.javaguides.Restful_webservice.service.impl;

import com.javaguides.Restful_webservice.entity.User;
import com.javaguides.Restful_webservice.repository.UserRepository;
import com.javaguides.Restful_webservice.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor


public class UserServiceImp implements UserService {
    private UserRepository userRepository;

    @Override
    public User CreateUser(User user) {
        return userRepository.save(user);
    }
}
