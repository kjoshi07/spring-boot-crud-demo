package com.kj.springbootcruddemo.controller;

import com.kj.springbootcruddemo.entity.User;
import com.kj.springbootcruddemo.model.MessageResponse;
import com.kj.springbootcruddemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

/**
 * The UserController Class is a Rest Controller class which will have all end points for User
 * which is includes POST, GET, GET ALL, PUT, DELETE.
 *
 * @author KJ
 * @version 1.0
 * @since 2018-04-28
 */

@RestController
@RequestMapping("/api/v1")   //Base Url.
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * Create a new USER by POST request, end point is http://hostname:port/api/va1/user
     *
     * @param user
     * @return user
     */
    @PostMapping(value = "/user")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return new ResponseEntity<Object>(createdUser, HttpStatus.CREATED);
    }

    /*** get a USER by ID in GET request, end point is http://hostname:port/api/va1/user/id
     * @param userId
     * @return
     */

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long userId) {
        User user = userService.findUserById(userId);
        if (user == null) {
            MessageResponse messageResponse = new MessageResponse();
            messageResponse.setMessage("User not found.");
            return new ResponseEntity<Object>(messageResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    /**get all list of users based on GET request.
     * @return
     */

    @GetMapping(value = "/user")
    public ResponseEntity<?> getAllUsers() {
        List<User> userList = userService.findAllUsers();
        return new ResponseEntity<Object>(userList, HttpStatus.OK);
    }

    /**Update a user based on PUT request.
     * @param userId
     * @param user
     * @return
     */

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setUserId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<Object>(updatedUser, HttpStatus.OK);
    }

    /**delete a user based on user ID.
     * @param userId
     * @return
     */
    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("User has been deleted successfully.");
        return new ResponseEntity<Object>(messageResponse, HttpStatus.OK);
    }
}
