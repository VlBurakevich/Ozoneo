package com.example.userservice.application.service;

import com.example.userservice.adapter.in.web.dto.request.LoginDto;
import com.example.userservice.adapter.in.web.dto.request.RegistrationDto;
import com.example.userservice.adapter.in.web.dto.response.UserInfoDto;
import com.example.userservice.adapter.in.web.dto.response.UserInfoListDto;
import com.example.userservice.adapter.in.web.mapper.UserInfoMapper;
import com.example.userservice.application.port.in.UserService;
import com.example.userservice.domain.model.Credential;
import com.example.userservice.domain.model.Role;
import com.example.userservice.domain.model.User;
import com.example.userservice.domain.repository.CredentialRepository;
import com.example.userservice.domain.repository.RoleRepository;
import com.example.userservice.domain.repository.UserRepository;
import com.example.userservice.infrastructure.util.AuthUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CredentialRepository credentialRepository;
    private final UserInfoMapper userInfoMapper;
    private final JwtService jwtService;
    private final RoleRepository roleRepository;

    public UserInfoListDto getUsers(Integer page, Integer size) {
        Page<User> usersPage = userRepository.findAll(PageRequest.of(page, size));
        List<UserInfoDto> users = usersPage.getContent().stream()
                .map(userInfoMapper::entityToDto)
                .toList();
        return new UserInfoListDto(users);
    }

    public UserInfoDto getUser(Long id) {
        return userInfoMapper.entityToDto(userRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public UserInfoDto getCurrentUserInfo() {
        return getUser(AuthUtil.getAuthenticatedUserId());
    }

    public String processLogin(LoginDto loginDto) {
        Credential credential = credentialRepository.findByEmail(loginDto.getEmail()).orElse(null);
        if (credential == null || !passwordEncoder.matches(loginDto.getPassword(), credential.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        return jwtService.generateToken(credential);
    }

    @Transactional
    public String processRegistration(RegistrationDto registrationDto) {
        validateRegistration(registrationDto);
        User user = createUser(registrationDto);
        userRepository.save(user);

        return "Register Successful" ;
    }

    private void validateRegistration(RegistrationDto registrationDto) {
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            throw new RuntimeException("Passwords do not match");
        }

        if (credentialRepository.existsByEmail(registrationDto.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
    }

    private User createUser(RegistrationDto registrationDto) {
        User user = new User();
        user.setFirstName(registrationDto.getFirstName());
        user.setLastName(registrationDto.getLastName());
        user.setPhone(registrationDto.getPhone());

        Credential credential = new Credential();
        credential.setEmail(registrationDto.getEmail());
        credential.setPasswordHash(passwordEncoder.encode(registrationDto.getPassword()));
        credential.setUser(user);
        credential.addRole(getUserRole());

        return user;
    }

    public Role getUserRole() {
        return roleRepository.findByName(Role.USER)
                .orElseThrow(() -> new RuntimeException("Role not found"));
    }

    @Transactional
    public UserInfoDto updateUserInfo(Long id, UserInfoDto userInfoDto) {
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        userInfoDto.setId(id);
        userInfoMapper.updateEntityToDto(userInfoDto, user);
        userRepository.save(user);

        return userInfoDto;
    }

    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }
}
