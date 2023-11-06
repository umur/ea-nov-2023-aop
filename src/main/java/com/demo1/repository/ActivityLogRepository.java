package com.demo1.repository;


import com.demo1.domain.entities.ActivityLog;
import org.springframework.data.repository.ListCrudRepository;

public interface ActivityLogRepository extends ListCrudRepository<ActivityLog, Long> {
}
