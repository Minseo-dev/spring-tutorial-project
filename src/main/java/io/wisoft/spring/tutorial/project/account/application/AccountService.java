package io.wisoft.spring.tutorial.project.account.application;

import io.wisoft.spring.tutorial.project.account.Account;
import io.wisoft.spring.tutorial.project.account.persistence.AccountRepository;
import io.wisoft.spring.tutorial.project.account.web.dto.FindAccountResponse;
import io.wisoft.spring.tutorial.project.handler.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(final AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public FindAccountResponse findAccountById(final Long accountId) {
        final Account account = accountRepository.findById(accountId)
                .orElseThrow(
                        () -> new AccountNotFoundException(accountId + "에 해당하는 사용자가 없습니다.")
                )
                .toDomain();

        return new FindAccountResponse(account);
    }

}
