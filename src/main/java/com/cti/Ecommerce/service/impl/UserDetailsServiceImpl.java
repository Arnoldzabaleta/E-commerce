package com.cti.Ecommerce.service.impl;

import com.cti.Ecommerce.exceptionHandler.exceptions.ResourceNotFoundException;
import com.cti.Ecommerce.models.entities.User;
import com.cti.Ecommerce.models.enums.Status;
import com.cti.Ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl  implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsService.class);

    private final UserRepository repository;

    @Override
    @Transactional // since when I load the load user, the roles and related authorities will be loaded too
    public UserDetails loadUserByUsername(String userEmail) {
        List<User> users = repository.findByEmail(userEmail);
        // Filter to find the user with a status other than CLOSED
        UserDetails userDetails = users.stream()
                .filter(user -> user.getAccountStatus() != Status.CLOSED)
                .findFirst()
                .orElseThrow(() -> {
                    logger.warn("User not found or status is CLOSED for email: {}", userEmail);
                    return new ResourceNotFoundException("User", "userEmail", userEmail);
                });
        logger.info("User loaded successfully: {}", userEmail);
        return userDetails;
    }
}
