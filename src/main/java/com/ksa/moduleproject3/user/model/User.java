package com.ksa.moduleproject3.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, name = "user_email")
    private String userEmail;

    @Column(nullable = false, name = "user_name")
    private String userName;

    @Column(length = 1, name = "user_gender")
    private String userGender;

    @Column(name = "user_birth")
    private int userBirth;

    @Builder
    public User(Long id, String userEmail, String userName, String userGender, int userBirth) {
        this.id = id;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userGender = userGender;
        this.userBirth = userBirth;
    }

}
