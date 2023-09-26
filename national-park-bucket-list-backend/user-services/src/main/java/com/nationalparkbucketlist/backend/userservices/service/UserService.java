package com.nationalparkbucketlist.backend.userservices.service;

import com.nationalparkbucketlist.backend.userservices.controller.UserController;
import com.nationalparkbucketlist.backend.userservices.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserController userController;

    public User getUser(String userName, String password) {

        User user = userController.getByUserNameAndPassword(userName, password);

        return user;
    }

    public boolean checkUserExist(String userName, String password) {

        boolean exist = userController.checkIfUserExistByUserNameAndPassword(userName, password);
        return exist;
    }

    public User createUser(User user) {
        return userController.createUser(user);
    }

    public Long getUserId(String userName, String password) {
        return userController.getIdByUserNameAndPassword(userName, password);
    }
}
