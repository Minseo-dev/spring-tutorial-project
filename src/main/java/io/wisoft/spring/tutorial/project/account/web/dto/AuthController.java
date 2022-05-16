package io.wisoft.spring.tutorial.project.account.web.dto;

import io.wisoft.spring.tutorial.project.account.application.AuthService;
import io.wisoft.spring.tutorial.project.account.web.dto.req.SignUpRequest;
import io.wisoft.spring.tutorial.project.account.web.dto.res.SignUpResponse;
import io.wisoft.spring.tutorial.project.global.web.validator.image.ValidationSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(
            @ModelAttribute
            @Validated(ValidationSequence.class) final SignUpRequest request
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(authService.signup(request));
    }

}
