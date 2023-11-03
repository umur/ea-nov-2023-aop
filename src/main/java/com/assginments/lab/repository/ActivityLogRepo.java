package com.assginments.lab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assginments.lab.entity.ActivityLog;

@Repository
public interface ActivityLogRepo extends CrudRepository<ActivityLog, Integer> {
}