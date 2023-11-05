package com.example.aopassignment5.repository;

import com.example.aopassignment5.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

    List<Review> findAllByProduct_Id(int id);
}
