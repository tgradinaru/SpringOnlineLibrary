package com.sda.traianszabi.onlinelibrary.repository;

import com.sda.traianszabi.onlinelibrary.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);
}
