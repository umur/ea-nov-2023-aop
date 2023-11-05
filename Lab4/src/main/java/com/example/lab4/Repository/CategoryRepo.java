package com.example.lab4.Repository;

import com.example.lab4.Model.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends ListCrudRepository<Category,Integer> {
    Category findById(int id);

    Category updateById(int id,Category category);
    void deleteById(int id);
}
