package com.assginments.lab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assginments.lab.entity.Review;
import com.assginments.lab.repository.Generic.GenericRepo;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
    // Find reviews of the product whose id is id.
    List<Review> findByProductId(int productId);

    List<Review> findByUserId(int userId);
}