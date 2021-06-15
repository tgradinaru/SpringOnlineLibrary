package com.sda.traianszabi.onlinelibrary.controller;

import com.sda.traianszabi.onlinelibrary.model.Book;
import com.sda.traianszabi.onlinelibrary.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.findAll();
    }

    @PostMapping("/books")
    public String createBook(@RequestBody Book book){
        bookService.save(book);
        return "Book saved";
    }

}
