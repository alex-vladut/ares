package org.ares.exception;

public class BusinessException extends AbstractException {
    private static final long serialVersionUID = 4475064768330026105L;

    public BusinessException(final String messageId, final String[] placeholders) {
	super(messageId, placeholders);
    }

    public BusinessException(final String messageId, final Throwable cause, final String[] placeholders) {
	super(messageId, cause, placeholders);
    }
}
