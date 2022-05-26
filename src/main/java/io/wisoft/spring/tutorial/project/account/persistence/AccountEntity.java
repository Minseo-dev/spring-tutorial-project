package io.wisoft.spring.tutorial.project.account.persistence;

import io.wisoft.spring.tutorial.project.account.Account;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "profile_img_path")
    private String profileImagePath;

    public AccountEntity() {};

    public AccountEntity(
            final String name, final String email,
            final String password, final String profileImagePath) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.profileImagePath = profileImagePath;
    }

    public static AccountEntity from(final Account account) {
        return new AccountEntity(
                account.getName(),
                account.getEmail(),
                account.getPassword(),
                account.getProfileImagePath()
        );
    }

    public Account toDomain() {
        return new Account(
                this.id,
                this.name,
                this.email,
                this.password,
                this.profileImagePath
        );
    }

}
