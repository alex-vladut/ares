package org.ares.domain.user.impl;

import org.ares.domain.model.user.UserEntity;
import org.ares.domain.user.UserDomain;
import org.ares.persistence.user.UserPersistence;

public class UserDomainImpl implements UserDomain {

	private final UserPersistence userPersistence;
	
	public UserDomainImpl(final UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}
	
	@Override
	public UserEntity findUser(final String username, final String password) {
	     return userPersistence.findUser(username, password);
	}

}
