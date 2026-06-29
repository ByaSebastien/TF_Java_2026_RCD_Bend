package be.bstorm.tf_java_2026_rcd_bend.controllers;

import be.bstorm.tf_java_2026_rcd_bend.models.forms.user.RegisterForm;
import be.bstorm.tf_java_2026_rcd_bend.services.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Valid @RequestBody RegisterForm form
            ) {

        authService.register(form.toEntity());
        return ResponseEntity.accepted().build();
    }

}
