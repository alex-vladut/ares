package org.ares.persistence.repository;

import org.ares.domain.model.activity.ActivityEntity;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<ActivityEntity, Long> {

}
