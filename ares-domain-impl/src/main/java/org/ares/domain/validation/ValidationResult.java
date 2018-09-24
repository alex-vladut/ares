package org.ares.domain.validation;

import java.util.ArrayList;
import java.util.List;

import org.ares.exception.ValidationRuntimeException;

public class ValidationResult {

    private final List<String> errorMessages = new ArrayList<>();

    public void addErrorMessage(final String errorMessage) {
	if (errorMessage == null) {
	    throw new NullPointerException("The argument cannot be null!");
	}
	this.errorMessages.add(errorMessage);
    }

    public boolean hasErrors() {
	return errorMessages.size() > 0;
    }

    public void throwValidationException() {
	if (hasErrors()) {
	    throw new ValidationRuntimeException(errorMessages);
	}
    }
}
