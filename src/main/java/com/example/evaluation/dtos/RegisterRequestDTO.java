package com.example.evaluation.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {

    @Size(min = 6, max = 30)
    private String username;

    @Size(min = 6, max = 30)
    private String nickname;

    @Email
    private String email;

    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$"
    )
    private String password;
}