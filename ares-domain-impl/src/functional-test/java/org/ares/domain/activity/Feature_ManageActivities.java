package org.ares.domain.activity;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * <b>Feature:</b> Manage activities:<br/>
 * <ol>
 * <li>create a new activity</li>
 * <li>update the details of an activity</li>
 * <li>delete one of my activities</li>
 * <li>view all available activites</li>
 * </ol>
 * 
 * @author alex
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ Story_CreateOrUpdateActivity.class, Story_DeleteActivity.class, Story_SearchActivities.class })
public class Feature_ManageActivities {

}
