package org.ares.persistence.activity.impl;

import org.ares.domain.model.activity.ActivityEntity;
import org.ares.persistence.activity.ActivityPersistence;
import org.ares.persistence.repository.ActivityRepository;

public class ActivityPersistenceImpl implements ActivityPersistence {

    private final ActivityRepository repository;

    public ActivityPersistenceImpl(final ActivityRepository repository) {
	if (repository == null) {
	    throw new NullPointerException("The parameter should not be null!");
	}

	this.repository = repository;
    }

    @Override
    public ActivityEntity createOrUpdate(final ActivityEntity activity) {
	return repository.save(activity);
    }

    @Override
    public void delete(long id) {
	repository.delete(id);
    }

    @Override
    public ActivityEntity findById(long id) {
	return repository.findOne(id);
    }

}
