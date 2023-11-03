package com.assginments.lab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assginments.lab.entity.Category;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {

}
