package com.nationalparkbucketlist.backend.parkservices.service;

import com.nationalparkbucketlist.backend.parkservices.controller.ParkController;
import com.nationalparkbucketlist.backend.parkservices.entity.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkService {

    @Autowired
    private ParkController parkController;


    public Park getParkById(Long id) {
        Park tempPark = parkController.getParkWithParkCheckedId(id);
        return tempPark;
    }
}
