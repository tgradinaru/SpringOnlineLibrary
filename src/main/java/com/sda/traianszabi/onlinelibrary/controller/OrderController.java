package com.sda.traianszabi.onlinelibrary.controller;

import com.sda.traianszabi.onlinelibrary.model.Order;
import com.sda.traianszabi.onlinelibrary.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/order/create")
    public String createOrder(@Valid @RequestBody Order order){
        orderService.addOrder(order);
        return "Order created";
    }

    @GetMapping("/orders")
    public Iterable<Order> getAllOrders(){
        return orderService.getOrders();
    }

}
