package com.flashcolorcard.springboot.app.commom.commonutils;

import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

@Component
public final class MessageSourceProvider implements MessageSourceAware {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(MessageSourceProvider.class);
    private static MessageSource messageSource;

    private MessageSourceProvider() {
    }

    public void setMessageSource(final MessageSource messageSource) {
        log.info("messageSource has been set.");
        synchronized(this) {
            MessageSourceProvider.messageSource = messageSource;
        }
    }

    public static MessageSource getMessageSource() {
        return messageSource;
    }
}
