package org.ares.persistence.repository;

import static java.lang.Long.valueOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.OrderingComparison.greaterThan;

import org.ares.domain.model.activity.ActivityEntity;
import org.ares.persistence.config.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class ActivityRepositoryTest {

    @Autowired
    private ActivityRepository uut;

    @Test
    public void unitUnderTestIsNotNull() {
	assertThat(uut, is(not(nullValue())));
    }

    @Test
    public void createNewActivity() {
	final ActivityEntity activity = createDummyActivity();
	final ActivityEntity savedActivity = uut.save(activity);

	assertThat(savedActivity, is(not(nullValue())));
	assertThat(savedActivity.getId(), is(greaterThan(valueOf(0))));
	assertThat(savedActivity.getId(), is(not(equalTo(0))));
	assertThat(savedActivity.getName(), equalTo(activity.getName()));
    }

    private ActivityEntity createDummyActivity() {
	final ActivityEntity result = new ActivityEntity();
	result.setName("Test Activity");

	return result;
    }

    @Test
    public void findActivityById() {
	createNewActivity();
	final ActivityEntity activity = uut.findOne((long) 1);

	assertThat(activity, is(not(nullValue())));
	assertThat(activity.getName(), is(not(nullValue())));
    }

    @Test
    public void deleteActivity() {
	final ActivityEntity activity = uut.save(createDummyActivity());
	assertThat(activity, is(not(nullValue())));
	assertThat(activity.getId(), is(greaterThan(valueOf(0))));

	uut.delete(activity.getId());

	assertThat(uut.findOne(activity.getId()), is(nullValue()));
    }

}
