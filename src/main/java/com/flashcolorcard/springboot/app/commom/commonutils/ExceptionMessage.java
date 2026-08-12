package com.flashcolorcard.springboot.app.commom.commonutils;

import org.springframework.http.HttpStatus;

public interface ExceptionMessage {
    String getValue();

    default HttpStatus getHttpStatus() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}
