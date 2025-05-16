package com.example.userservice.adapter.in.web.controller;


import com.example.userservice.adapter.in.web.dto.request.LoginDto;
import com.example.userservice.adapter.in.web.dto.request.RegistrationDto;
import com.example.userservice.adapter.in.web.dto.response.UserInfoDto;
import com.example.userservice.adapter.in.web.dto.response.UserInfoListDto;
import com.example.userservice.application.port.in.UserService;
import com.example.userservice.infrastructure.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public UserInfoListDto getUsers(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size
    ) {
        return userService.getUsers(page, size);
    }

    @GetMapping("/{id}")
    public UserInfoDto getUser(
        @PathVariable Long id
    ) {
        return userService.getUser(id);
    }

    @GetMapping("/profile")
    public UserInfoDto getCurrentUserInfo() {
        return userService.getCurrentUserInfo();
    }

    @PostMapping("/login")
    public String processLogin(
            @RequestBody LoginDto loginDto
    ) {
        return userService.processLogin(loginDto);
    }

    @PostMapping("/registration")
    public String processRegistration(
            @RequestBody RegistrationDto registrationDto
    ) {
        return userService.processRegistration(registrationDto);
    }

    @PutMapping("/{id}")
    public UserInfoDto updateUser(
            @PathVariable Long id,
            @RequestBody UserInfoDto userInfoDto
    ) {
        return userService.updateUserInfo(id, userInfoDto);
    }

    @PutMapping("/profile")
    public UserInfoDto updateCurrentUserInfo(
            @RequestBody UserInfoDto userInfoDto
    ) {
        return userService.updateUserInfo(AuthUtil.getAuthenticatedUserId(), userInfoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
