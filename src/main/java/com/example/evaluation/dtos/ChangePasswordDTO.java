package com.example.evaluation.dtos;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordDTO {
    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$"
    )
    private String currentPassword;

    @Pattern(
            regexp = "^[a-zA-Z0-9@$!%?&]{8,30}$"
    )
    private String newPassword;
}
