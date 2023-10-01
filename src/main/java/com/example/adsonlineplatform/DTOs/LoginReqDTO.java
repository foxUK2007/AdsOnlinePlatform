package com.example.adsonlineplatform.DTOs;

import lombok.Data;

@Data
public class LoginReqDTO {
    private String password;
    private String username;
}