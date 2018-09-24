package org.ares.domain.model.activity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.ares.domain.model.AbstractEntity;
import org.ares.domain.model.user.UserEntity;

@Entity
@Table(name = "activities")
public class ActivityEntity extends AbstractEntity {
    private static final long serialVersionUID = 2955479548256157495L;
    @NotNull
    private String            name;
    @NotNull
    private UserEntity        owner;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public UserEntity getOwner() {
	return owner;
    }

    public void setOwner(UserEntity owner) {
	this.owner = owner;
    }

}
