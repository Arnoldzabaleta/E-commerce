package com.cti.Ecommerce.service.impl;

import com.cti.Ecommerce.exceptionHandler.exceptions.ApiException;
import com.cti.Ecommerce.models.dto.requestDto.UserRegisterRequestDto;
import com.cti.Ecommerce.models.entities.OtpToken;
import com.cti.Ecommerce.models.entities.User;
import com.cti.Ecommerce.repository.OtpTokenRepository;
import com.cti.Ecommerce.repository.UserRepository;
import com.cti.Ecommerce.request_setting.RequestResult;
import com.cti.Ecommerce.service.AuthentificationService;
import com.cti.Ecommerce.service.EmailService;
import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

import static com.cti.Ecommerce.models.enums.Status.CLOSED;
import static com.cti.Ecommerce.request_setting.RequestResultConstant.*;

@Component
public class AuthentificationServiceImpl implements AuthentificationService {

    @Autowired
    private OtpTokenRepository otpTokenRepository;

    private static final Logger logger = LoggerFactory.getLogger(AuthentificationService.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EmailService emailService;

    @Autowired
    @Value("${application.mailing.frontend.activation-url}")
    private String activationUrl;

    @Autowired
    @Value("${application.security.otp.length}")
    private int otpLength;

    @Override
    public RequestResult<?> registerUser(UserRegisterRequestDto request) throws MessagingException {
        return null;
    }


    private boolean isEmailUsable (String email){
            List<User> users = userRepository.findByEmail(email);
            return users.stream()
                    .allMatch(user -> user.getAccountStatus() == CLOSED);
    }

    private String generateAndSaveActivationToken(User user) {
        logger.info("Generating activation token for user {}", user.getEmail());

        // generate Otp token
        String generatedToken = generateActivationCode(otpLength);

        var otpToken = OtpToken.builder()
                .token(generatedToken)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(5))
                .user(user)
                .build();
        otpTokenRepository.save(otpToken);
        logger.info("Activation token saved for user {}", user.getEmail());
        return generatedToken;
    }

    private void sendValidationEmail(User user) throws MessagingException {
        var newToken = generateAndSaveActivationToken(user);

        // send email
        String ACTIVATE_ACCOUNT = "activate_account";
        emailService.sendEmail(
                user.getEmail(),
                user.fullName(),
                ACTIVATE_ACCOUNT,
                activationUrl,
                newToken,
                "Account activation"
        );
    }

    private String generateActivationCode(int length) {
        logger.debug("Generating activation code of length {}", length);

        String characters = "0123456789";
        StringBuilder codeBuilder = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < length; i++) {
            int randomIndex = secureRandom.nextInt(characters.length()); // 0..9
            codeBuilder.append(characters.charAt(randomIndex));
        }

        logger.debug("Generated activation code");
        return codeBuilder.toString();
    }


}

