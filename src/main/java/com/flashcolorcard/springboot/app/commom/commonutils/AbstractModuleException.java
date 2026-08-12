package com.flashcolorcard.springboot.app.commom.commonutils;

import lombok.Generated;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public abstract class AbstractModuleException extends RuntimeException {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(AbstractModuleException.class);
    private final transient MessageSource messageSource;
    private static final long serialVersionUID = 2158306598214272677L;
    protected static final Object[] EMPTY_ARGUMENTS = new Object[0];
    protected final String code;
    protected final transient ExceptionMessage exceptionMessage;
    protected final transient Object[] arguments;
    protected final transient List<HttpError> errors;

    protected AbstractModuleException(String code, Throwable exception, String message, Object... arguments) {
        super(message, exception);
        this.code = code;
        this.errors = new ArrayList();
        this.arguments = arguments;
        this.exceptionMessage = null;
        this.messageSource = MessageSourceProvider.getMessageSource();
    }

    protected AbstractModuleException(ExceptionMessage exceptionMessage, Throwable exception, String message, Object... arguments) {
        super(message, exception);
        this.code = exceptionMessage.getValue();
        this.errors = new ArrayList();
        this.arguments = arguments;
        this.exceptionMessage = exceptionMessage;
        this.messageSource = MessageSourceProvider.getMessageSource();
    }

    protected AbstractModuleException(String code, Throwable exception, List<HttpError> errors, String message, Object... arguments) {
        super(message, exception);
        this.code = code;
        this.errors = errors;
        this.arguments = arguments;
        this.exceptionMessage = null;
        this.messageSource = MessageSourceProvider.getMessageSource();
    }

    protected AbstractModuleException(ExceptionMessage exceptionMessage, Throwable exception, List<HttpError> errors, String message, Object... arguments) {
        super(message, exception);
        this.code = exceptionMessage.getValue();
        this.errors = errors;
        this.arguments = arguments;
        this.exceptionMessage = exceptionMessage;
        this.messageSource = MessageSourceProvider.getMessageSource();
    }

    protected AbstractModuleException(String code, Throwable exception, HttpError error, String message, Object... arguments) {
        super(message, exception);
        this.code = code;
        this.errors = Collections.singletonList(error);
        this.arguments = arguments;
        this.exceptionMessage = null;
        this.messageSource = MessageSourceProvider.getMessageSource();
    }

    protected AbstractModuleException(ExceptionMessage exceptionMessage, Throwable exception, HttpError error, String message, Object... arguments) {
        super(message, exception);
        this.code = exceptionMessage.getValue();
        this.errors = Collections.singletonList(error);
        this.arguments = arguments;
        this.exceptionMessage = exceptionMessage;
        this.messageSource = MessageSourceProvider.getMessageSource();
    }

    public String getCode() {
        return this.code;
    }

    public Object[] getArguments() {
        return this.arguments == null ? EMPTY_ARGUMENTS : (Object[])this.arguments.clone();
    }

    public List<HttpError> getErrors() {
        return this.errors;
    }

    public String toString() {
        String clazz = this.getClass().getName();
        String message = String.format(this.getLocalizedMessage(), this.arguments);
        return !StringUtils.isEmpty(message) ? clazz + ": " + this.code + " - " + message : clazz;
    }

    public String resolveMessage() {
        String defaultMessage = !this.getMessage().equals(this.getCode()) ? this.getMessage() : this.getCode();
        return this.messageSource.getMessage(this.getCode(), this.getArguments(), defaultMessage, Locale.getDefault());
    }

    public ExceptionMessage getExceptionMessage() {
        return this.exceptionMessage;
    }
}

