package edu.ea.springaop.repository;

import edu.ea.springaop.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository  extends JpaRepository<ActivityLog,Long> {
}
