package com.sda.traianszabi.onlinelibrary.repository;

import com.sda.traianszabi.onlinelibrary.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAllByBookName(String bookName);

    List<Book> findAllByAuthorName(String authorName);

    List<Book> findAllByCategoryContaining(String categoryName);
}
