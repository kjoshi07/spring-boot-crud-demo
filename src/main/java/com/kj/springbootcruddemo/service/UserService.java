package com.kj.springbootcruddemo.service;

import com.kj.springbootcruddemo.entity.User;

import java.util.List;

/**
 * A interface to define all required methods for user Object.
 * @author KJ
 * @version 1.0
 * @since 2018-05-25
 */
public interface UserService {

    User saveUser(User user);

    User findUserById(Long userId);

    List<User> findAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
