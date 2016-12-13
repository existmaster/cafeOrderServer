package com.narae.cafe.user.service;

import com.narae.cafe.coffee.domain.Coffee;
import com.narae.cafe.user.domain.User;
import com.narae.cafe.user.store.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by existmaster on 2016. 11. 26..
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> findAllUser() {
        return userRepository.findAll();
    }

    public void removeUser(String id) {
        userRepository.delete(id);
    }

    public User findUser(String id) {
        return userRepository.findOne(id);
    }
    public boolean checkUser(String id) {
        return userRepository.exists(id);
    }
}
