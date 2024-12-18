package com.example.backend.domain.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class EmailCheckRequestDto {

    @Email
    @NotEmpty(message = "이메일을 입력해 주세요.")
    private String email;

    @NotEmpty(message = "인증 번호를 입력해 주세요.")
    private String verificationCode;
}
