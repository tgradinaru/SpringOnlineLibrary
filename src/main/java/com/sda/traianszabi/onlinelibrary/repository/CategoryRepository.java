package com.sda.traianszabi.onlinelibrary.repository;

import com.sda.traianszabi.onlinelibrary.model.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAllByCategoryDescription(String categoryDescription);
}
