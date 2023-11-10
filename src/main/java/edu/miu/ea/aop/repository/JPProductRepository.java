package edu.miu.ea.aop.repository;

import edu.miu.ea.aop.model.domain.JPProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPProductRepository extends JpaRepository<JPProduct, Long> {
}
