package com.example.service;


import com.example.mode.User;
import org.springframework.data.repository.CrudRepository;

/**
 * User类的CRUD操作
 * @see User
 * @author ScienJus
 * @date 2015/7/10.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    public User findByUsername(String username);
}
