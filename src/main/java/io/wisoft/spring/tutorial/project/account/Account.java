package io.wisoft.spring.tutorial.project.account;

import lombok.Getter;

@Getter
public class Account {

    private Long id;
    private String name;
    private String email;
    private String password;
    private String profileImagePath;

    public Account(
            final String name,
            final String email,
            final String password,
            final String profileImagePath
    ) {
        this(null, name, email, password, profileImagePath);
    }

    public Account(
            final Long id,
            final String name,
            final String email,
            final String password,
            final String profileImagePath
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImagePath = profileImagePath;
    }

}
