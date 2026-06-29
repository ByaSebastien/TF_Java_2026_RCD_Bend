package be.bstorm.tf_java_2026_rcd_bend.models.user;

import jakarta.validation.constraints.NotBlank;

public record LoginForm(
        @NotBlank
        String username,
        @NotBlank
        String password
) {
}
