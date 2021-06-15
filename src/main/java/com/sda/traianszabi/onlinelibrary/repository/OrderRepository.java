package com.sda.traianszabi.onlinelibrary.repository;

import com.sda.traianszabi.onlinelibrary.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Long> {
}
