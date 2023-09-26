package com.nationalparkbucketlist.backend.userservices.entity;



import jakarta.persistence.*;


@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="user_name")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    public User() {

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
}
