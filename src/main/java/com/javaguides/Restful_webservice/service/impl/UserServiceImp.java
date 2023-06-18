package com.javaguides.Restful_webservice.service.impl;

import com.javaguides.Restful_webservice.dto.UserDto;
import com.javaguides.Restful_webservice.entity.User;
import com.javaguides.Restful_webservice.mapper.UserMapper;
import com.javaguides.Restful_webservice.repository.UserRepository;
import com.javaguides.Restful_webservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor


public class UserServiceImp implements UserService {
    private UserRepository userRepository;



    @Override
    public UserDto CreateUser(UserDto userDto) {

      //Convert UserDto into user JPA Entity
        User user2= UserMapper.mapToUser(userDto);
        User savedUser= userRepository.save(user2);
        //convert user JPA entity to userDto
        UserDto savedUserDto =UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public UserDto getUserByidd(Long userid) {
        Optional<User> optionaluser= userRepository.findById(userid);
        User user= optionaluser.get();
        return UserMapper.mapToUserDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users= userRepository.findAll();
       return users.stream().map(UserMapper ::mapToUserDto).collect(Collectors.toList());
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
