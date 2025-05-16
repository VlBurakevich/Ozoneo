package com.example.userservice.adapter.in.web.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    @Email(message = "Invalid email address")
    private String email;

    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
}
