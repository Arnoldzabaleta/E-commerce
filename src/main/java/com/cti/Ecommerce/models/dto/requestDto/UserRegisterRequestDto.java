package com.cti.Ecommerce.models.dto.requestDto;

import com.cti.Ecommerce.models.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
@Builder
public class UserRegisterRequestDto {
    private String firstname;

    private String lastname;

    @Email
    @NotEmpty
    @NotBlank
    private String email;

    @NotBlank @NotEmpty @NotNull
    private String password;

    private LocalDate dateOfBirth;

    private Gender gender;

    @NotBlank
    @NotEmpty @NotNull
    private String country;

    @NotBlank @NotEmpty
    private String userType; // "admin", "client"

}
