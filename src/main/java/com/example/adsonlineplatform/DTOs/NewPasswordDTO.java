package com.example.adsonlineplatform.DTOs;

import lombok.Data;

@Data
public class NewPasswordDTO {

    private String currentPassword;
    private String newPassword;

}