package com.sda.traianszabi.onlinelibrary.service;

import com.sda.traianszabi.onlinelibrary.model.Book;
import com.sda.traianszabi.onlinelibrary.model.Order;
import com.sda.traianszabi.onlinelibrary.model.User;
import com.sda.traianszabi.onlinelibrary.repository.BookRepository;
import com.sda.traianszabi.onlinelibrary.repository.OrderRepository;
import com.sda.traianszabi.onlinelibrary.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class OrderService{

    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;

    }

    @Transactional
    public void addOrder(Order order) {
        orderRepository.save(order);

    }
    public Iterable<Order> getOrders(){ return orderRepository.findAll();}
}
