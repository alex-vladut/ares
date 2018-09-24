package org.ares.domain.validation.impl;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.ares.domain.model.AbstractEntity;
import org.ares.domain.validation.IValidator;
import org.ares.domain.validation.ValidationResult;

public class GenericValidator<T extends AbstractEntity> implements IValidator<T> {

    private final Validator validator;

    public GenericValidator(final Validator validator) {
	this.validator = validator;
    }

    @Override
    public ValidationResult validate(final T obj) {
	final Set<ConstraintViolation<T>> violations = validator.validate(obj);
	final ValidationResult result = new ValidationResult();
	for (final ConstraintViolation<T> violation : violations) {
	    result.addErrorMessage(violation.getMessage());
	}
	return result;
    }

    @Override
    public boolean isValid(final T obj) {
	final Set<ConstraintViolation<T>> violations = validator.validate(obj);
	return violations.isEmpty();
    }

}
