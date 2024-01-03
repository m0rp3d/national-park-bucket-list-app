package com.nationalparkbucketlist.backend.userservices.controller;

import com.nationalparkbucketlist.backend.userservices.dao.UserRepository;
import com.nationalparkbucketlist.backend.userservices.entity.User;
import com.nationalparkbucketlist.backend.userservices.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nationalparkbucketlist.backend.userservices.entity.User.SEQUENCE_NAME;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    // get a list of users matching a username and password
    @GetMapping("/getuser/{userName}/and/{password}")
    public User getByUserNameAndPassword(@PathVariable String userName, @PathVariable String password) {

       List<User> matches = userRepository.findByUserNameAndPassword(userName, password);
       User theUser = new User();
       if(matches.isEmpty() == true) {
           throw new RuntimeException("No user that matches username and password");
       } else {
           // return user at first index, makes sure only one user with username and password returned
           theUser = matches.get(0);
       }
       return theUser;
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        // generate sequence
        user.setId(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME));
        //System.out.println(user.getId());
        return userRepository.save(user);
    }

    @GetMapping("/getall/users")
    public List<User> getAllUsers() {

        return userRepository.findAll();

    }


    @GetMapping("/getuserid/{userName}/and/{password}")
    public Long getIdByUserNameAndPassword(@PathVariable String userName, @PathVariable String password) {
        List<User> matches = userRepository.findByUserNameAndPassword(userName, password);
        User theUser = new User();
        if(matches.isEmpty() == true) {
            throw new RuntimeException("No user that matches username and password");
        } else {
            // return user at first index, makes sure only one user with username and password returned
            theUser = matches.get(0);
        }
        return theUser.getId();
    }


    /*




    @GetMapping("/userexist/{userName}/and/{password}")
    public boolean checkIfUserExistByUserNameAndPassword(@PathVariable String userName, @PathVariable String password) {
        boolean exist = false;
        List<User> matches = userRepository.findByUserNameAndPassword(userName, password);
        if(matches.isEmpty() == true) {
            exist = false;
        } else {
            // return true if user with matching userName and password exist
            exist = true;
        }

        return exist;
    }



    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable Long id) {

        User user = userRepository.getReferenceById(id);

        userRepository.delete(user);
    }


     */
}
