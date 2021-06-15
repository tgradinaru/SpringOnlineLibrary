package com.sda.traianszabi.onlinelibrary.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_library")
public class Order {
    //public UserService userService;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
   // @JoinColumn(name = "book_id")
    private List<Book> books;

    @Column(name = "order_date")
    private Date orderDate;

    public Order(){}

    public Order(User user, List<Book> books, Date orderDate) {
        this.user = user;
        this.books = books;
        this.orderDate = orderDate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", orderDate=" + orderDate +
                '}';
    }


}
