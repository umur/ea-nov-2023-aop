package edu.miu.ea.aop.repository;

import edu.miu.ea.aop.model.domain.JPAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPAddressRepository extends JpaRepository<JPAddress, Long> {
}
