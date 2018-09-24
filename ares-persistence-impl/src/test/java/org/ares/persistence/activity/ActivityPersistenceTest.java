package org.ares.persistence.activity;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.ares.domain.model.activity.ActivityEntity;
import org.ares.persistence.activity.impl.ActivityPersistenceImpl;
import org.ares.persistence.repository.ActivityRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ActivityPersistenceTest {

    private ActivityPersistence uut;
    private ActivityEntity      activity;
    private ActivityRepository  repository;

    @Before
    public void init() {
	repository = mock(ActivityRepository.class);
	activity = spy(createDummyActivity());
	when(repository.findOne(anyLong())).thenReturn(activity);
	when(repository.save(activity)).thenReturn(activity);

	uut = new ActivityPersistenceImpl(repository);
    }

    private ActivityEntity createDummyActivity() {
	final ActivityEntity result = new ActivityEntity();
	result.setName("Test Activity");

	return result;
    }

    @Test
    public void unitUnderTestIsNotNull() {
	assertThat(uut, is(not(nullValue())));
    }

    @Test
    public void createNewActivity() {
	final ActivityEntity savedActivity = uut.createOrUpdate(activity);

	assertThat(savedActivity, is(not(nullValue())));
	assertThat(savedActivity.getId(), is(not(0)));
	assertThat(savedActivity.getName(), is(activity.getName()));
    }

    @Test
    public void findActivityById() {
	final ActivityEntity activity = uut.findById(1);

	assertThat(activity, is(not(nullValue())));
	assertThat(activity.getName(), is(not(nullValue())));
    }

    @Test
    public void deleteActivityWithId() {
	uut.delete(anyLong());

	verify(repository, only()).delete(anyLong());
    }

}
