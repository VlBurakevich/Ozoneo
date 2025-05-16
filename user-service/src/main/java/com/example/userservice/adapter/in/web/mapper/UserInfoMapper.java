package com.example.userservice.adapter.in.web.mapper;

import com.example.userservice.adapter.in.web.dto.response.UserInfoDto;
import com.example.userservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserInfoMapper {
    UserInfoDto entityToDto(User user);

    void updateEntityToDto(UserInfoDto dto, @MappingTarget User user);
}
