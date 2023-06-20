package com.javaguides.Restful_webservice.mapper;

import com.javaguides.Restful_webservice.dto.UserDto;
import com.javaguides.Restful_webservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper

public interface AutoMapperUser {
    // to match two different entities in the source and destination we use Mapping
    //@Mapping(source = "email",target ="email address")
    AutoMapperUser MAPPER = Mappers.getMapper(AutoMapperUser.class);
    UserDto mapToUserDto(User user);

    User mapToUser(UserDto userDto);

}
