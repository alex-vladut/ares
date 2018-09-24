package org.ares.domain.activity;

import org.ares.domain.model.activity.ActivityEntity;

public interface ActivityDomain {

    ActivityEntity findActivityById(long id);

    ActivityEntity createActivity(ActivityEntity activity);

    void updateActivity(ActivityEntity activity);

    void deleteActivityWithId(long id);
}
