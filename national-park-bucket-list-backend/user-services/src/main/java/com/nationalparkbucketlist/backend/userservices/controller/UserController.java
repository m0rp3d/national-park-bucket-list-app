package com.nationalparkbucketlist.backend.userservices.controller;

import com.nationalparkbucketlist.backend.userservices.dao.UserRepository;
import com.nationalparkbucketlist.backend.userservices.entity.User;
import com.nationalparkbucketlist.backend.userservices.service.SequenceGeneratorService;
import com.nationalparkbucketlist.backend.userservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nationalparkbucketlist.backend.userservices.entity.User.SEQUENCE_NAME;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;



    // get a user
    @GetMapping("/getuser/{email}/and/{password}")
    @CrossOrigin(origins = "http://localhost:4200")
    public User getByEmailAndPassword(@PathVariable String email, @PathVariable String password) {
       User theUser = userService.getUserByEmailAndPassword(email, password);

       if(theUser.getUserName() == null) {
           throw new RuntimeException("No user that matches email and password");
       }

        return theUser;
    }

    @PostMapping("/user")
    @CrossOrigin(origins = "http://localhost:4200")
    public User createUser(@RequestBody User user){
        String username = user.getUserName();
        //String password = user.getPassword();
        String email = user.getEmail();


        //List<User> matches = userRepository.findByUserNameOrEmail(username, email);

        boolean exist = userService.userExistWithUserNameAndEmail(username, email);
        if(exist == true) {
            throw new RuntimeException("User matches username and password");
        } else {
            // return user at first index, makes sure only one user with username and password returned
            user.setId(sequenceGeneratorService.getSequenceNumber(User.SEQUENCE_NAME));
        }

        return userService.postUser(user);
    }


    /*

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

    @GetMapping("/getall/users")
    public List<User> getAllUsers() {

        return userRepository.findAll();

    }

    // for testing
    @GetMapping("/userexist/{userName}/and/{email}")
    public boolean checkIfUserExistByUserNameAndEmail(@PathVariable String userName, @PathVariable String email) {
        boolean exist = false;
        List<User> matches = userRepository.findByUserNameOrEmail(userName, email);
        if(matches.isEmpty() == true) {
            exist = false;
        } else {
            // return true if user with matching userName and email exist
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
