package io.wisoft.spring.tutorial.project.account.web.dto;

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

    public FindAccountResponse(final Account account) {
        this.name = account.getName();
        this.email = account.getEmail();
        this.profileImageName = FileHandler
                .getFileName(account.getProfileImagePath());
    }

}
