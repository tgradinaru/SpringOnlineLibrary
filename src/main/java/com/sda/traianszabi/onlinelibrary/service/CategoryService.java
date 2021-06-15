package com.sda.traianszabi.onlinelibrary.service;

import com.sda.traianszabi.onlinelibrary.model.Book;
import com.sda.traianszabi.onlinelibrary.model.Category;
import com.sda.traianszabi.onlinelibrary.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void addCategory(Category category){
        categoryRepository.save(category);
    }
    public Iterable<Category> getCategories(){return categoryRepository.findAll();}
}
