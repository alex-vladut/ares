package org.ares.domain.validation;

import org.ares.domain.model.AbstractEntity;

public interface IValidator<T extends AbstractEntity> {
    ValidationResult validate(T obj);

    boolean isValid(T obj);
}
