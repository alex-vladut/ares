package org.ares.controller.exception.handler;

import org.ares.exception.AbstractRuntimeException;
import org.ares.exception.ValidationRuntimeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    private final MessageSource messageSource;

    @Autowired
    public GlobalExceptionHandler(final MessageSource messageSource) {
	this.messageSource = messageSource;
    }

    @ExceptionHandler(AbstractRuntimeException.class)
    public ExceptionInfo handleApplicationRuntimeExceptions(final AbstractRuntimeException e) {
	final String message = messageSource.getMessage("test", null, null);
	final ExceptionInfo result = new ExceptionInfo();
	result.setMessage(message);
	return result;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationRuntimeException.class)
    public ExceptionInfo handleValidationExceptions(final ValidationRuntimeException e) {
	System.out.println("Exception handling!");
	return new ExceptionInfo();
    }

}
