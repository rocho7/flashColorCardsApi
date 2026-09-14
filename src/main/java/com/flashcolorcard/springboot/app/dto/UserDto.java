package com.flashcolorcard.springboot.app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDto {

    private  Long id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    @Email
    private String email;

    @NotNull
    @NotBlank
    private String password;

    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name.toLowerCase().trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase().trim();
    }

    public String getPassword() {
        return password !=null ? password.trim() : password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
