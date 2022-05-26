package io.wisoft.spring.tutorial.project.account.web.dto.res;

import lombok.Getter;

@Getter
public class SignInResponse {

    private Long accountId;

    public SignInResponse(final Long accountId) {
        this.accountId = accountId;
    }

}
