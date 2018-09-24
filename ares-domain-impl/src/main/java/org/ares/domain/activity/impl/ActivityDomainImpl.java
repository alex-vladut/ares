package org.ares.domain.activity.impl;

import org.ares.domain.activity.ActivityDomain;
import org.ares.domain.model.activity.ActivityEntity;
import org.ares.domain.validation.IValidator;
import org.ares.domain.validation.ValidationResult;
import org.ares.persistence.activity.ActivityPersistence;

public class ActivityDomainImpl implements ActivityDomain {
    private final ActivityPersistence        persistence;
    private final IValidator<ActivityEntity> validator;

    public ActivityDomainImpl(final ActivityPersistence persistence, final IValidator<ActivityEntity> validator) {
	if (persistence == null) {
	    throw new IllegalArgumentException();
	}
	this.persistence = persistence;
	this.validator = validator;
    }

    @Override
    public ActivityEntity findActivityById(final long id) {
	return persistence.findById(id);
    }

    @Override
    public ActivityEntity createActivity(final ActivityEntity activity) {
	validateActivity(activity);
	return persistence.createOrUpdate(activity);
    }

    @Override
    public void updateActivity(final ActivityEntity activity) {
	validateActivity(activity);
	if (activity.getId() <= 0) {
	    throw new IllegalArgumentException("The id should be grather than 0!");
	}

	persistence.createOrUpdate(activity);
    }

    private void validateActivity(final ActivityEntity activity) {
	final ValidationResult result = validator.validate(activity);
	if (result.hasErrors()) {
	    result.throwValidationException();
	}
    }

    @Override
    public void deleteActivityWithId(final long id) {
	if (id <= 0) {
	    throw new IllegalArgumentException("Activity's id should be greater than 0!");
	}

	persistence.delete(id);
    }

}
