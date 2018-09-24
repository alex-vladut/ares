package org.ares.persistence.user.impl;

import org.ares.domain.model.user.UserEntity;
import org.ares.persistence.repository.UserRepository;
import org.ares.persistence.user.UserPersistence;

public class UserPersistenceImpl implements UserPersistence{
	private final UserRepository repository;
	
	public UserPersistenceImpl(final UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserEntity findUser(String username, String password) {
		final UserEntity entity = new UserEntity();
		entity.setUsername(username);
		entity.setPassword(password);
		entity.setFirstName("John");
		entity.setLastName("Snow");
		repository.save(entity);
		return repository.findByUsernameAndPassword(username, password);
	}

	
}
