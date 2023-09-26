package com.nationalparkbucketlist.backend.parkcheckedservices.entity;

import jakarta.persistence.*;

@Entity
@Table(name="park_checked")
public class ParkChecked {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="park_name")
    private String parkName;

    @Column(name="state_name")
    private String stateName;

    @Column(name="traveled")
    private boolean traveled;

    @Column(name="park_id")
    private long parkId;

    @Column(name="user_id")
    private long userId;

    public ParkChecked() {

    }

    public ParkChecked(String parkName, String stateName, boolean traveled, long parkId, long userId) {

        this.parkName = parkName;
        this.stateName = stateName;
        this.traveled = traveled;
        this.parkId = parkId;
        this.userId = userId;
    }

    public long getId() {
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

    public boolean isTraveled() {
        return traveled;
    }

    public void setTraveled(boolean traveled) {
        this.traveled = traveled;
    }

    public long getParkId() {
        return parkId;
    }

    public void setParkId(long parkId) {
        this.parkId = parkId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
