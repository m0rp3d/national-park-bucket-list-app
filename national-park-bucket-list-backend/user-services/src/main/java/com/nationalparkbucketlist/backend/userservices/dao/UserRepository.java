package com.nationalparkbucketlist.backend.userservices.dao;

import com.nationalparkbucketlist.backend.userservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {

    List<User> findByUserNameAndPassword(String userName, String password);
}
