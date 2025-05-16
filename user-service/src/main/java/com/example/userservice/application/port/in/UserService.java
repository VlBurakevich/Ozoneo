package com.example.userservice.application.port.in;

import com.example.userservice.adapter.in.web.dto.request.LoginDto;
import com.example.userservice.adapter.in.web.dto.request.RegistrationDto;
import com.example.userservice.adapter.in.web.dto.response.UserInfoDto;
import com.example.userservice.adapter.in.web.dto.response.UserInfoListDto;

public interface UserService {
    UserInfoListDto getUsers(Integer page, Integer size);

    UserInfoDto getUser(Long id);

    UserInfoDto getCurrentUserInfo();

    String processLogin(LoginDto loginDto);

    String processRegistration(RegistrationDto registrationDto);

    UserInfoDto updateUserInfo(Long id, UserInfoDto userInfoDto);

    void deleteUser(Long id);
}
