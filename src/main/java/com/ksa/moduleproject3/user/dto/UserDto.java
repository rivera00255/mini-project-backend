package com.ksa.moduleproject3.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {

    private String userEmail;
    private String userName;
    private String userGender;
    private String userBirth;

    @Builder
    public UserDto(String userEmail, String userName, String userGender, String userBirth) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userGender = userGender;
        this.userBirth = userBirth;
    }
}
