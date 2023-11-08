package com.miu.edu.student.bacha.lab3.repositories;

import com.miu.edu.student.bacha.lab3.models.Review;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends ListCrudRepository<Review, Integer> {
    List<Review> findByProductId(int productId);
}
