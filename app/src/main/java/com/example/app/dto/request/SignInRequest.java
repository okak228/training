package com.example.app.dto.request;

import lombok.Data;

@Data
public class SignInRequest {
    private String name;
    private String password;
}
