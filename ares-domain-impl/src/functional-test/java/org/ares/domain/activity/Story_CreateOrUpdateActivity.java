package org.ares.domain.activity;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.ares.domain.activity.impl.ActivityDomainImpl;
import org.ares.domain.model.activity.ActivityEntity;
import org.ares.domain.model.user.UserEntity;
import org.ares.domain.validation.IValidator;
import org.ares.domain.validation.ValidationResult;
import org.ares.persistence.activity.ActivityPersistence;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * <b>User Story:</b> <br/>
 * In order to find some partners for my game<br/>
 * As a user<br/>
 * I want to create a new activity and update its details<br/>
 * 
 * @author alex
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class Story_CreateOrUpdateActivity {
    private ActivityDomain             sut;
    @Mock
    private ActivityPersistence        persistence;
    @Mock
    private ActivityEntity             activity;
    @Mock
    private IValidator<ActivityEntity> validator;

    @Before
    public void createSystemUnderTest() {
	given(validator.validate(activity)).willReturn(new ValidationResult());
	sut = new ActivityDomainImpl(persistence, validator);
    }

    /**
     * <b>Scenario:</b><br/>
     * Given I want to create an activity called <i>'my activity'</i><br/>
     * When I ask it to be created<br/>
     * Then the activity will be saved<br/>
     */
    @Test
    public void shouldCreateAnActivityWhenAllDetailsAreRight() {
	given(activity.getName()).willReturn("my activity");
	given(activity.getOwner()).willReturn(mock(UserEntity.class));

	sut.createActivity(activity);

	verify(persistence, only()).createOrUpdate(activity);
    }

    /**
     * <b>Scenario:</b><br/>
     * Given I am the owner of an activity<br/>
     * And I want to modify activity's name to 'my updated activity'<br/>
     * When I ask the modification to take place<br/>
     * Then the activity will be updated<br/>
     */
    @Test
    public void shouldUpdateActivityWhenAllDetailsAreRight() {
	given(activity.getName()).willReturn("my updated activity");
	given(activity.getOwner()).willReturn(mock(UserEntity.class));
	given(activity.getId()).willReturn(Long.valueOf(1));

	sut.updateActivity(activity);

	verify(persistence, only()).createOrUpdate(activity);
    }

}
