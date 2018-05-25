package com.kj.springbootcruddemo.service;

import com.kj.springbootcruddemo.entity.User;
import com.kj.springbootcruddemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * A implementation class for all user methods.
 * @author KJ
 * @version 1.0
 * @since 2018-05-25
 */

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * Save a new user.
     * @param user
     * @return
     */

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Find a user based in user ID.
     * @param userId
     * @return
     */

    @Override
    public User findUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    /**
     * find all users in system.
     * @return
     */

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Update a user based on user ID.
     * @param user
     * @return
     */

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Delete a user based on User ID.
     * @param userId
     */

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);

    }
}
