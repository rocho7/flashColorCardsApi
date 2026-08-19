package com.flashcolorcard.springboot.app.dto.user;

import lombok.Data;

@Data
public class ResponseUserDto {

    private Long id;

    private String name;

    private String email;
}
