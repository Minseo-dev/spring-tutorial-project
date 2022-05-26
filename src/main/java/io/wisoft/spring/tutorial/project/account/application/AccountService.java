package io.wisoft.spring.tutorial.project.account.application;

import io.wisoft.spring.tutorial.project.account.Account;
import io.wisoft.spring.tutorial.project.account.persistence.AccountRepository;
import io.wisoft.spring.tutorial.project.account.web.dto.res.FindAccountResponse;
import io.wisoft.spring.tutorial.project.handler.FileHandler;
import io.wisoft.spring.tutorial.project.handler.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

}
