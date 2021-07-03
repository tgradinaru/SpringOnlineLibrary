package com.sda.traianszabi.onlinelibrary.service;

import com.sda.traianszabi.onlinelibrary.model.Book;
import com.sda.traianszabi.onlinelibrary.model.Category;
import com.sda.traianszabi.onlinelibrary.repository.BookRepository;
import com.sda.traianszabi.onlinelibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BookService(BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void save(Book book) {
        book.setCategory(categoryRepository.findById(book.getCategory().getId()).orElse(null));
        bookRepository.save(book);

    }

    public void addBook(Book book, Category category) {
        bookRepository.save(book);
        categoryRepository.save(category);
    }

    public List<Book> findAll() {
        return StreamSupport.stream(bookRepository.findAll().spliterator(),
                false).collect(Collectors.toList());

    }

    public Iterable<Book> getBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public boolean bookExists(String bookName) {
        Book bookExisting = bookRepository.findByBookName(bookName);
        return bookExisting != null;
    }

    public void createBook(Book book) {
        Book bookToBeSaved = new Book();
        bookToBeSaved.setBookName(book.getBookName());
        bookToBeSaved.setAuthorName(book.getAuthorName());
        bookToBeSaved.setDescription(book.getDescription());
        bookToBeSaved.setCategory(book.getCategory());
        bookRepository.save(bookToBeSaved);
    }
}

