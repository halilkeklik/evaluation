package com.example.evaluation.dtos;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    @Size(min = 6, max = 30)
    private String username;

    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$"
    )
    private String password;
}
