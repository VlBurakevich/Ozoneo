package com.example.userservice.infrastructure.util;

import com.example.userservice.domain.model.User;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@UtilityClass
public class AuthUtil {
    public static User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User user) {
            return user;
        }
        throw new RuntimeException();
    }

    public static Long getAuthenticatedUserId() {
        return getAuthenticatedUser().getId();
    }

}
