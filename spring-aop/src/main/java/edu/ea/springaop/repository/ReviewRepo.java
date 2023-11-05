package edu.ea.springaop.repository;

import edu.ea.springaop.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo  extends JpaRepository<Review,Integer> {
}
