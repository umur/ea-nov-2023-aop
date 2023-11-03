package edu.miu.lab4.Repository;

import edu.miu.lab4.Model.ActivityLog;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends ListCrudRepository<ActivityLog,Integer> {
}
