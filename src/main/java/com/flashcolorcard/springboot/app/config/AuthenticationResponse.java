package com.flashcolorcard.springboot.app.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AuthenticationResponse {

    final private String jwt;
}
