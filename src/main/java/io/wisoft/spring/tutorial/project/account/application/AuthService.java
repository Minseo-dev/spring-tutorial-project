package io.wisoft.spring.tutorial.project.account.application;

import io.wisoft.spring.tutorial.project.account.Account;
import io.wisoft.spring.tutorial.project.account.persistence.AccountEntity;
import io.wisoft.spring.tutorial.project.account.persistence.AccountRepository;
import io.wisoft.spring.tutorial.project.account.web.dto.req.SignInRequest;
import io.wisoft.spring.tutorial.project.account.web.dto.req.SignUpRequest;
import io.wisoft.spring.tutorial.project.account.web.dto.res.SignInResponse;
import io.wisoft.spring.tutorial.project.account.web.dto.res.SignUpResponse;
import io.wisoft.spring.tutorial.project.handler.FileHandler;
import io.wisoft.spring.tutorial.project.handler.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private final AccountRepository accountRepository;

    @Autowired
    public AuthService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

}
