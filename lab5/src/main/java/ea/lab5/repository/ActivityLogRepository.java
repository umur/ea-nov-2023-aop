package ea.lab5.repository;

import ea.lab5.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends JpaRepository <ActivityLog, Integer> {
}
