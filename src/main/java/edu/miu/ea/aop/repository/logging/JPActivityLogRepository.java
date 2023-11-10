package edu.miu.ea.aop.repository.logging;

import edu.miu.ea.aop.model.domain.logging.JPActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPActivityLogRepository extends JpaRepository<JPActivityLog, Long> {
}
