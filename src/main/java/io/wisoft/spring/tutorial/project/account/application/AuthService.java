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

@Service
public class AuthService {

    private final AccountRepository accountRepository;

    @Autowired
    public AuthService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public SignUpResponse signup(final SignUpRequest request) {

        final String profileImagePath = FileHandler.saveFileData(request.getProfileImage());

        Account account = new Account(
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                profileImagePath
        );

        account = accountRepository
                .save(AccountEntity.from(account))
                .toDomain();

        return new SignUpResponse(account.getId());
    }

    public SignInResponse signin(final SignInRequest request) {
        final Account account = accountRepository.findByEmail(request.getEmail())
                .orElseThrow(
                        () -> new AccountNotFoundException(request.getEmail() + "에 해당하는 사용자를 찾을 수 없습니다.")
                )
                .toDomain();

        account.checkPassword(request.getPassword());

        return new SignInResponse(account.getId());
    }
}
