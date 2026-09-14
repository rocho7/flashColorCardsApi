package com.flashcolorcard.springboot.app.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

//    private String name;

    private String email;

    private String password;

    public String getEmail() {
        return email.toLowerCase().trim();
    }

    public void setEmail(String email) {
        this.email = email.toLowerCase().trim();
    }
}
