package com.sda.traianszabi.onlinelibrary.service;

import com.sda.traianszabi.onlinelibrary.model.Book;
import com.sda.traianszabi.onlinelibrary.model.Category;
import com.sda.traianszabi.onlinelibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(),
                false).collect(Collectors.toList());

    }
}
