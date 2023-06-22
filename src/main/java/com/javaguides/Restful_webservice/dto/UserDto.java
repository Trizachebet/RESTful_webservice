package com.javaguides.Restful_webservice.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private Long id;
    @NotEmpty(message = "First name should not null")
    private String firstName;
    @NotEmpty(message = "Last name should not be null")
    private String lastName;
    @NotEmpty(message = "Email should not be null")
    @Email(message = "Provide a valid email")
    private String email;
}
