package com.nationalparkbucketlist.backend.parkservices.entity;

import jakarta.persistence.*;

@Entity
@Table(name="park")
public class Park {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="park_name")
    private String parkName;

    @Column(name="state_name")
    private String stateName;

    @Column(name="image")
    private String image;

    @Column(name="directions")
    private String directions;

    @Column(name="about")
    private String about;

    @Column(name="costs")
    private String costs;

    @Column(name="activities")
    private String activities;

    public Park() {

    }

    public Park(String parkName, String stateName, String image, String directions, String about, String costs, String activities) {
        this.parkName = parkName;
        this.stateName = stateName;
        this.image = image;
        this.directions = directions;
        this.about = about;
        this.costs = costs;
        this.activities = activities;
    }

    public Long getId() {
        return id;
    }

    public String getParkName() {
        return parkName;
    }

    public void setParkName(String parkName) {
        this.parkName = parkName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getCosts() {
        return costs;
    }

    public void setCosts(String costs) {
        this.costs = costs;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }
}