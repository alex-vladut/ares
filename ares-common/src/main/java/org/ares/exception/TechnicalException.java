package org.ares.exception;

public class TechnicalException extends AbstractException {
    private static final long serialVersionUID = 7908466939499106194L;

    public TechnicalException(final String messageId, final String[] placeholders) {
	super(messageId, placeholders);
    }

    public TechnicalException(final String messageId, final Throwable cause, final String[] placeholders) {
	super(messageId, cause, placeholders);
    }
}
