package org.ares.persistence.repository;

import org.ares.domain.model.user.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

	UserEntity findByUsernameAndPassword(String username, String password);
}
