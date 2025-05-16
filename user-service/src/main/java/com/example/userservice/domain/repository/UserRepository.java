package com.example.userservice.domain.repository;

import com.example.userservice.domain.model.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsById(Long id);

    @NotNull
    Page<User> findAll(@NotNull Pageable pageable);
}
