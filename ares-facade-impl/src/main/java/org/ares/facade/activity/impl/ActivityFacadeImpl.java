package org.ares.facade.activity.impl;

import org.ares.domain.activity.ActivityDomain;
import org.ares.domain.model.activity.ActivityEntity;
import org.ares.facade.activity.ActivityFacade;
import org.ares.facade.mapper.MapperAdapter;
import org.ares.view.transfer.data.ActivityDTO;

public class ActivityFacadeImpl implements ActivityFacade {
    private final ActivityDomain domain;
    private final MapperAdapter  mapper;

    public ActivityFacadeImpl(final ActivityDomain domain, final MapperAdapter mapper) {
	this.domain = domain;
	this.mapper = mapper;
    }

    @Override
    public ActivityDTO findActivityById(final long id) {
	checkIdValidity(id);
	final ActivityEntity activity = domain.findActivityById(id);

	return mapper.map(activity, ActivityDTO.class);
    }

    @Override
    public ActivityDTO createActivity(final ActivityDTO activity) {
	if (activity == null) {
	    throw new NullPointerException();
	}
	final ActivityEntity savedActivity = domain.createActivity(mapper.map(activity, ActivityEntity.class));

	return mapper.map(savedActivity, ActivityDTO.class);
    }

    @Override
    public void updateActivity(final ActivityDTO activity) {
	if (activity == null) {
	    throw new NullPointerException();
	}
	domain.createActivity(mapper.map(activity, ActivityEntity.class));
    }

    @Override
    public void deleteActivityWithId(final long id) {
	checkIdValidity(id);
	domain.deleteActivityWithId(id);
    }

    private void checkIdValidity(final long id) {
	if (id <= 0) {
	    throw new IllegalArgumentException("The id should be greather than 0!");
	}
    }

}
