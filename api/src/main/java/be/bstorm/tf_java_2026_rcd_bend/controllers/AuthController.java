package be.bstorm.tf_java_2026_rcd_bend.controllers;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import be.bstorm.tf_java_2026_rcd_bend.models.user.LoginForm;
import be.bstorm.tf_java_2026_rcd_bend.models.user.RegisterForm;
import be.bstorm.tf_java_2026_rcd_bend.models.user.UserDto;
import be.bstorm.tf_java_2026_rcd_bend.models.user.UserTokenDto;
import be.bstorm.tf_java_2026_rcd_bend.services.AuthService;
import be.bstorm.tf_java_2026_rcd_bend.utils.JwtUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;
    private final JwtUtils  jwtUtils;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Valid @RequestBody RegisterForm form
            ) {

        authService.register(form.toEntity());
        return ResponseEntity.accepted().build();
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public ResponseEntity<UserTokenDto> login(
            @Valid @RequestBody LoginForm form
    ) {

        User user = authService.login(form.username(), form.password());

        UserTokenDto response = new UserTokenDto(UserDto.fromUser(user), jwtUtils.generateToken(user));

        return ResponseEntity.ok(response);
    }

}
