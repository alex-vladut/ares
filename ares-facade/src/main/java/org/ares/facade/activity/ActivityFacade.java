package org.ares.facade.activity;

import org.ares.view.transfer.data.ActivityDTO;

public interface ActivityFacade {

    ActivityDTO findActivityById(long id);

    ActivityDTO createActivity(ActivityDTO activity);

    void updateActivity(ActivityDTO activity);

    void deleteActivityWithId(long id);
}
