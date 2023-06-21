package com.javaguides.Restful_webservice.service.impl;

import com.javaguides.Restful_webservice.dto.UserDto;
import com.javaguides.Restful_webservice.entity.User;
import com.javaguides.Restful_webservice.exception.EmailException;
import com.javaguides.Restful_webservice.exception.ResourceNotFoundException;
import com.javaguides.Restful_webservice.mapper.AutoMapperUser;
import com.javaguides.Restful_webservice.mapper.UserMapper;
import com.javaguides.Restful_webservice.repository.UserRepository;
import com.javaguides.Restful_webservice.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor


public class UserServiceImp implements UserService {
    private ModelMapper modelMapper;
    private UserRepository userRepository;



    @Override
    public UserDto CreateUser(UserDto userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (optionalUser.isPresent()){
            throw new EmailException("Email already exists");

        }

      //Convert UserDto into user JPA Entity
        //User user2= UserMapper.mapToUser(userDto);
        // User user2= modelMapper.map(userDto,User.class);
        User user2= AutoMapperUser.MAPPER.mapToUser(userDto);
        User savedUser= userRepository.save(user2);

        //convert user JPA entity to userDto
        //UserDto savedUserDto =UserMapper.mapToUserDto(savedUser);
       // UserDto savedUserDto =modelMapper.map(savedUser, UserDto.class);
        UserDto savedUserDto = AutoMapperUser.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;

    }

    @Override
    public UserDto getUserByidd(Long userid) {
        User user = userRepository.findById(userid).orElseThrow(
                () -> new ResourceNotFoundException("User","id", userid)
        );
        //new ResourceNotFoundException("User","id", userid)
        //User user= optionaluser.get();
        //return UserMapper.mapToUserDto(user);
        //return modelMapper.map(user,UserDto.class);
        return AutoMapperUser.MAPPER.mapToUserDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users= userRepository.findAll();
       //return users.stream().map(UserMapper ::mapToUserDto).collect(Collectors.toList());
        //return users.stream().map((user) -> modelMapper.map(user ,UserDto.class))
               // .collect(Collectors.toList());
        return users.stream().map((user) -> AutoMapperUser.MAPPER.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUserByid(UserDto user ) {
        User existingUser= userRepository.findById(user.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("User","id", user.getId())
        );
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updatedUser=userRepository.save(existingUser);
        //return modelMapper.map(updatedUser, UserDto.class);
        return AutoMapperUser.MAPPER.mapToUserDto(updatedUser);
    }

    @Override
    public void deleteByid(Long userid) {
        User existingUser= userRepository.findById(userid).orElseThrow(
                ()-> new ResourceNotFoundException("User","id", userid)
        );
       userRepository.deleteById(userid);
    }



}
