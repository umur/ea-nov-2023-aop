package edu.miu.ea.aop.repository;

import edu.miu.ea.aop.model.domain.JPCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPCategoryRepository extends JpaRepository<JPCategory, Long> {
}
