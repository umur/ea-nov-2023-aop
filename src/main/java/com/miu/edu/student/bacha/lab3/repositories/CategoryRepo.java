package com.miu.edu.student.bacha.lab3.repositories;

import com.miu.edu.student.bacha.lab3.models.Category;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends ListCrudRepository<Category, Integer> {
}
