package com.miu.lab4aop.repository;

import com.miu.lab4aop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}