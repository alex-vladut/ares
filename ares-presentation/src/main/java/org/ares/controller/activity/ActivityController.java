package org.ares.controller.activity;

import org.ares.facade.activity.ActivityFacade;
import org.ares.view.transfer.data.ActivityDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    private final ActivityFacade facade;

    public ActivityController(final ActivityFacade facade) {
	this.facade = facade;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ActivityDTO saveActivity(final ActivityDTO activity) {
	return facade.createActivity(activity);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateActivity(final ActivityDTO activity) {
	facade.updateActivity(activity);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ActivityDTO getActivity(@PathVariable("id") final long id) {
	return facade.findActivityById(id);
    }
}
