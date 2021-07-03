package com.sda.traianszabi.onlinelibrary.controller;

import com.sda.traianszabi.onlinelibrary.error.ResourceNotFoundException;
import com.sda.traianszabi.onlinelibrary.model.Book;
import com.sda.traianszabi.onlinelibrary.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") Long bookId) throws ResourceNotFoundException {
        Optional<Book> book = bookService.findById(bookId);
        if (book.isPresent()) {
            return ResponseEntity.ok(book.get());
        }
        throw new ResourceNotFoundException("Book with id: " + bookId + " was not found");
    }

    @PostMapping("/book/create")
    public String createBook(@Valid @RequestBody Book book) {
        /*if (bookService.bookExists(book.getBookName())) {
            return ResponseEntity.badRequest().build();
        }*/
        bookService.createBook(book);
        return "Book successfully created";
    }
}
