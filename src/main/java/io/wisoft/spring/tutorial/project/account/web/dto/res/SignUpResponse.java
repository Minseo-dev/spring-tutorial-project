package io.wisoft.spring.tutorial.project.account.web.dto.res;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponse {

    private Long accountId;

    public SignUpResponse(final Long accountId) {
        this.accountId = accountId;
    }

}
