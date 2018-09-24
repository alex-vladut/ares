package org.ares.domain.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.ares.domain.model.AbstractEntity;

@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {
    private static final long serialVersionUID = -857276374565546141L;
    private String            firstName;
    private String            lastName;
    private String            username;
    private String            password;

    @Column(name = "username")
    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    @Column(name = "first_name")
    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

}
