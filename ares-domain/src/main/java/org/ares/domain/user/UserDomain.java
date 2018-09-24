package org.ares.domain.user;

import org.ares.domain.model.user.UserEntity;

public interface UserDomain {

	public UserEntity findUser(String username, String password);
}
