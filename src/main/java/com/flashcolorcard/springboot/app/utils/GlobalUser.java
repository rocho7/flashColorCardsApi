package com.flashcolorcard.springboot.app.utils;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Data
public class GlobalUser {

    private Long id;
    private String email;
    private String name;
}
