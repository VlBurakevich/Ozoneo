package com.example.userservice.adapter.in.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDateTime createdAt;
}
