package org.ares.exception;

public class TechnicalRuntimeException extends AbstractRuntimeException {
    private static final long serialVersionUID = -855364769696902849L;

    public TechnicalRuntimeException(final String messageId, final String... placeholders) {
	super(messageId, placeholders);
    }

    public TechnicalRuntimeException(final String messageId, final Throwable cause, final String... placeholders) {
	super(messageId, cause, placeholders);
    }

}
