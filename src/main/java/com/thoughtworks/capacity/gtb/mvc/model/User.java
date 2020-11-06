package com.thoughtworks.capacity.gtb.mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    @NotBlank(message = "username must not be null")
    @Pattern(regexp = "[a-zA-Z0-9.\\\\-_]{3,10}", message = "username is invalid")
    private String username;
    @NotBlank(message = "password must not be null")
    @Length(min = 5, max = 12, message = "password is invalid")
    private String password;
    @Email(message = "email should be valid")
    private String email;

}

