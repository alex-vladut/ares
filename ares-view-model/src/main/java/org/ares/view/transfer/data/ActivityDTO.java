package org.ares.view.transfer.data;

import java.time.Period;

public class ActivityDTO {
    private long   id;
    private String name;
    private Period period;

    public void setId(long id) {
	this.id = id;
    }

    public long getId() {
	return id;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public void setPeriod(Period period) {
	this.period = period;
    }

    public Period getPeriod() {
	return period;
    }
}
