package org.ares.persistence.activity;

import org.ares.domain.model.activity.ActivityEntity;

public interface ActivityPersistence {

    ActivityEntity createOrUpdate(ActivityEntity activity);

    void delete(long id);

    ActivityEntity findById(long id);
}
