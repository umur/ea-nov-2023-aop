package com.miu.edu.student.bacha.lab3.repositories;

import com.miu.edu.student.bacha.lab3.models.ActivityLog;
import org.springframework.data.repository.ListCrudRepository;

public interface ActivityLogRepo extends ListCrudRepository<ActivityLog, Integer> {
}
