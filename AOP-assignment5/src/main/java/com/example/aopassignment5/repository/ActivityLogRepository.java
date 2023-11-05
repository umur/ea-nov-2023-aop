package com.example.aopassignment5.repository;

import com.example.aopassignment5.model.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository  extends JpaRepository<ActivityLog,Long> {
}