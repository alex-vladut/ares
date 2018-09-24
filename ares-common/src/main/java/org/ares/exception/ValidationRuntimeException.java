package org.ares.exception;

import java.util.List;

public class ValidationRuntimeException extends RuntimeException {
    private static final long  serialVersionUID = 737800524022937506L;
    private final List<String> errorMessages;

    public ValidationRuntimeException(final List<String> errorMessages) {
	this.errorMessages = errorMessages;
    }

    public List<String> getErrorMessages() {
	return errorMessages;
    }
}
