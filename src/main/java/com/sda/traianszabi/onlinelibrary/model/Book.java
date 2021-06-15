package com.sda.traianszabi.onlinelibrary.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long isbn;

    @NotBlank
    @Size(min = 1, max = 1000)
    @Column(name = "book_name")
    private String bookName;

    @NotBlank
    @Size(min = 1, max = 1000)
    @Column(name = "author_name")
    private String authorName;

    @NotBlank
    @Size(min = 5, max = 10000)
    @Column(name = "description")
    private String description;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="release_Date")
    private Timestamp releaseDate;


    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Timestamp getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Timestamp releaseDate) {
        this.releaseDate = Timestamp.from(Instant.now());
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", bookName='" + bookName + '\'' +
                ", authorName='" + authorName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
