package com.nationalparkbucketlist.backend.userservices.dao;

import com.nationalparkbucketlist.backend.userservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {

    List<User> findByUserNameAndPassword(String userName, String password);

    // used to see if user already exist with email
    Optional<User> findUserByEmail(String email);
}
