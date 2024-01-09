package com.nationalparkbucketlist.backend.userservices.service;

import com.nationalparkbucketlist.backend.userservices.controller.UserController;
import com.nationalparkbucketlist.backend.userservices.dao.UserRepository;
import com.nationalparkbucketlist.backend.userservices.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User postUser(User user) {

        return userRepository.save(user);
    }

    public boolean userExistWithUserNameAndEmail(String username, String email) {

        List<User> matches = userRepository.findByUserNameOrEmail(username, email);

        if(matches.isEmpty() == false) {
            return true;
        }

        return false;
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User user = new User();
        try {
            user = userRepository.findByEmailAndPassword(email, password).get(0);
        } catch(Exception e) {
            System.out.println("No user exist with this email and password");
        }

        return user;
    }

    /*
    public List<User> getUserWithUsernameAndPassword(String username, String password) {

        return userRepository.findByUserNameAndPassword(username, password);
    }

     */


}
