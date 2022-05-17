package io.wisoft.spring.tutorial.project.account.web.dto.res;

import io.wisoft.spring.tutorial.project.account.Account;
import io.wisoft.spring.tutorial.project.handler.FileHandler;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FindAccountResponse {

    private String name;
    private String email;
    private String profileImageName;

    public FindAccountResponse(
            final String name,
            final String email,
            final String profileImageName
    ) {
        this.name = name;
        this.email = email;
        this.profileImageName = profileImageName;
    }

}
