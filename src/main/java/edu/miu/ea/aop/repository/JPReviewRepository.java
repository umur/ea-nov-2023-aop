package edu.miu.ea.aop.repository;

import edu.miu.ea.aop.model.domain.JPReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPReviewRepository extends JpaRepository<JPReview, Long> {
}
