package io.wisoft.spring.tutorial.project.account.web;

import io.wisoft.spring.tutorial.project.account.application.AuthService;
import io.wisoft.spring.tutorial.project.account.web.dto.req.SignInRequest;
import io.wisoft.spring.tutorial.project.account.web.dto.req.SignUpRequest;
import io.wisoft.spring.tutorial.project.account.web.dto.res.SignInResponse;
import io.wisoft.spring.tutorial.project.account.web.dto.res.SignUpResponse;
import io.wisoft.spring.tutorial.project.global.web.validator.image.ValidationSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
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

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signin(
            @RequestBody @Valid final SignInRequest request
    ) {
        return ResponseEntity
                .ok(authService.signin(request));
    }

}
