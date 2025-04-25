package com.cti.Ecommerce.service;

import com.cti.Ecommerce.models.dto.requestDto.UserRegisterRequestDto;
import com.cti.Ecommerce.request_setting.RequestResult;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface AuthentificationService {

    RequestResult<?> registerUser(UserRegisterRequestDto request) throws MessagingException;
}
