package org.ares.persistence.user;

import org.ares.domain.model.user.UserEntity;

public interface UserPersistence {

    UserEntity findUser(String username, String password);

}
