package com.cti.Ecommerce.service.impl;

import com.cti.Ecommerce.exceptionHandler.exceptions.ApiException;
import com.cti.Ecommerce.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.cti.Ecommerce.request_setting.RequestResultConstant.MESSAGE_EMAIL_NOT_SEND;
import static com.cti.Ecommerce.request_setting.RequestResultConstant.RESULT_CODE_EMAIL_NOT_SEND;

@Component
public class EmailServiceImpl implements EmailService {

    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private SpringTemplateEngine templateEngine;
    @Autowired
    private JavaMailSender mailSender;
    private final String JUNIOR_LOGO = "images/junior.png";
    private final String  PNG_MIME = "image/png";


    public  void sendEmail(
            String to,
            String username,
            String emailTemplate,
            String confirmationUrl,
            String token,
            String subject
    ) throws MessagingException {
        try {
            String templateName;
            templateName = Objects.requireNonNullElse(emailTemplate, "confirm-email");

            MimeMessage mimeMessage = mailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(
                    mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED,
                    StandardCharsets.UTF_8.name()
            );

            Map<String, Object> properties = new HashMap<>();
            properties.put("email", to);
            properties.put("username", username);
            properties.put("confirmationUrl", confirmationUrl);
            properties.put("token", token);

            Context context = new Context();
            context.setVariables(properties);
            context.setVariable("imageResourceName", "logo.png");

            mimeMessageHelper.setFrom("steffjefferson404@gmail.com");
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.addInline("logo.png", new ClassPathResource(JUNIOR_LOGO), PNG_MIME);

            String template = templateEngine.process(templateName, context); //context in case we have parameters

            mimeMessageHelper.setText(template, true);

            mailSender.send(mimeMessage);

            logger.info("Email sent successfully to {}", to);
        }
        catch (Exception e){
            logger.error(MESSAGE_EMAIL_NOT_SEND + ". " + e.getMessage());
            throw new ApiException(
                    RESULT_CODE_EMAIL_NOT_SEND,
                    MESSAGE_EMAIL_NOT_SEND + ". " + e.getMessage()
            );
        }
    }


}
