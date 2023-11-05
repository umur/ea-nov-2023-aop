package com.example.lab4.Repository;

import com.example.lab4.Model.ActivityLog;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepo extends ListCrudRepository<ActivityLog,Integer> {
}
