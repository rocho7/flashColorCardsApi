package com.flashcolorcard.springboot.app.dto;

import lombok.Data;

@Data
public class UserDto {

    private  Long id;

    private String name;

    private String email;

    private String password;

    public String getName() {
        return name.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email.trim();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password.trim();
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
