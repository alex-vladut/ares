package org.ares.exception;

import java.util.UUID;

public abstract class AbstractException extends Exception {
    private static final long serialVersionUID = -6098331618372583695L;

    private final String      messageId;
    private final String[]    placeholders;
    private final String      uuid;

    public AbstractException(final String messageId, final String... placeholders) {
	this.messageId = messageId;
	this.placeholders = placeholders;
	this.uuid = UUID.randomUUID().toString();
    }

    public AbstractException(final String messageId, final Throwable cause, final String... placeholders) {
	super(cause);
	this.messageId = messageId;
	this.placeholders = placeholders;
	this.uuid = UUID.randomUUID().toString();
    }

    public String getMessageId() {
	return messageId;
    }

    public String[] getPlaceholders() {
	return placeholders;
    }

    public String getUuid() {
	return uuid;
    }
}
