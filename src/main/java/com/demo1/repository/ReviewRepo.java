package com.demo1.repository;

import com.demo1.domain.entities.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends ListCrudRepository<Review, Integer> {
}
