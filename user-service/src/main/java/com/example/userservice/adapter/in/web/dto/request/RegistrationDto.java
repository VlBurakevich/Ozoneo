package com.example.userservice.adapter.in.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {

    @Size(min = 4, max = 50, message = "Must be between 4 and 50 characters long")
    private String firstName;

    @Size(min = 4, max = 50, message = "Must be between 4 and 50 characters long")
    private String lastName;

    @Email(message = "Invalid email address")
    private String email;

    @Pattern(regexp = "\\+?\\d{10,15}", message = "Invalid phone number")
    private String phone;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @Size(min = 8, message = "Confirm Password must be at least 8 characters long")
    private String confirmPassword;
}
