package io.wisoft.spring.tutorial.project.account.web.dto.res;

import lombok.Getter;

@Getter
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
