package edu.miu.ea.aop.repository;

import edu.miu.ea.aop.model.domain.JPUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPUserRepository extends JpaRepository<JPUser, Long> {
}
