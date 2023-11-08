package com.example.AOP.repository;

import com.example.AOP.entity.ActivityLog;
import org.springframework.data.repository.ListCrudRepository;

public interface LogRepo extends ListCrudRepository<ActivityLog , Integer> {
}
