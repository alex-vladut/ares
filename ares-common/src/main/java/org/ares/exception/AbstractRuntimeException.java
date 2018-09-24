package org.ares.exception;

import java.util.UUID;

public abstract class AbstractRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -8844103203949665177L;

    private final String      messageId;
    private final String[]    placeholders;
    private final String      uuid;

    public AbstractRuntimeException(final String messageId, final String... placeholders) {
	this.messageId = messageId;
	this.placeholders = placeholders;
	this.uuid = UUID.randomUUID().toString();
    }

    public AbstractRuntimeException(final String messageId, final Throwable cause, final String... placeholders) {
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
