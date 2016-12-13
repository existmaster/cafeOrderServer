package com.narae.cafe.user.controller;

import com.narae.cafe.coffee.domain.Coffee;
import com.narae.cafe.exception.*;
import com.narae.cafe.user.domain.User;
import com.narae.cafe.user.service.UserService;
import com.narae.cafe.user.store.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by existmaster on 2016. 11. 30..
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private UserRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<User> findAllUser(){
        return service.findAllUser();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    User readUser(@PathVariable String userId) {
        this.validateUser(userId);
        return service.findUser(userId);
    }

    private void validateUser(String userId) {
        if(!service.checkUser(userId))
            throw new UserNotFoundException(userId);
    }

}
