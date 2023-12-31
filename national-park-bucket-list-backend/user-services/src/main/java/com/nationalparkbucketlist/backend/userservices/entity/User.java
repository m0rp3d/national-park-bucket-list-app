package com.nationalparkbucketlist.backend.userservices.entity;



import jakarta.persistence.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


//@Entity
// for mongodb we use @Document instead of @Entity
//@Table(name="user")
@Document(collection = "user")
public class User {

    @Transient
    public static final  String SEQUENCE_NAME = "user_sequence";

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="id")
    private long id;

    @Indexed(unique = true)
    //@Column(name="user_name")
    private String userName;

    //@Column(name="password")
    private String password;

    @Indexed(unique = true)
   // @Column(name="email")
    private String email;

    public User() {

    }

    public User(long id, String userName, String password, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public User(String userName, String password, String email) {

        this.userName = userName;
        this.password = password;
        this.email = email;

    }

    public long getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
