package com.example.userservice.domain.repository;

import com.example.userservice.domain.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
    Optional<Credential> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<Credential> findByUserId(Long userId);
}
