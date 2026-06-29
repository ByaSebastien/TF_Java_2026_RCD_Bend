package be.bstorm.tf_java_2026_rcd_bend.models.forms.user;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterForm(
        @NotBlank(message = "Username is required")
        @Size(min = 1, max = 50)
        String username,
        @NotBlank
        @Size(min = 4)
        String password
) {

        public User toEntity() {
                return new User(username, password);
        }
}
