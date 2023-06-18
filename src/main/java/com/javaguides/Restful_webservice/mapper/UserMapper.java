package com.javaguides.Restful_webservice.mapper;

import com.javaguides.Restful_webservice.dto.UserDto;
import com.javaguides.Restful_webservice.entity.User;

public class UserMapper {
    //converts UserJPA to UserDTO
    public static UserDto mapToUserDto(User user){
        UserDto userDto= new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail()

        );
return userDto;
    }
    //convert UserDto intgo user jpa Entity
    public static User mapToUser(UserDto userDto){
        User user= new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail()

        );
       return user;
    }
}
