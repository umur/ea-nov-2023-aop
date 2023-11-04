package edu.miu.repository;

import edu.miu.model.ActivityLog;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends ListCrudRepository<ActivityLog, Long> {
}
