package com.javaguides.Restful_webservice.service.impl;

import com.javaguides.Restful_webservice.entity.User;
import com.javaguides.Restful_webservice.repository.UserRepository;
import com.javaguides.Restful_webservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor


public class UserServiceImp implements UserService {
    private UserRepository userRepository;

    @Override
    public User CreateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByidd(Long userid) {
        Optional<User> optionaluser= userRepository.findById(userid);
        return optionaluser.get();
    }

    @Override
    public List<User> getAllUsers() {
       List<User> users= userRepository.findAll();
        return userRepository.findAll();
    }

    @Override
    public User updateUserByid(User user ) {
        User existingUser= userRepository.findById(user.getId()).get();
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser=userRepository.save(existingUser);
        return updatedUser;
    }

    @Override
    public void deleteByid(Long userid) {
       userRepository.deleteById(userid);
    }


}
