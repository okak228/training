package com.example.app.dto.response;

import lombok.Data;

@Data
public class SignInRs {
    private final String name;
    private final String role;
    private final String accessToken;

    public SignInRs(
            String name,
            String role,
            String accessToken
    ) {
        this.name = name;
        this.role = role;
        this.accessToken = accessToken;
    }

}
