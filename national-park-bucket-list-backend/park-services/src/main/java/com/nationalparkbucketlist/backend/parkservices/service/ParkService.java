package com.nationalparkbucketlist.backend.parkservices.service;

import com.nationalparkbucketlist.backend.parkservices.controller.ParkController;
import com.nationalparkbucketlist.backend.parkservices.dao.ParkRepository;
import com.nationalparkbucketlist.backend.parkservices.entity.Park;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkService {

    @Autowired
    private ParkRepository parkRepository;


    public Park getParkUsingParkCheckedId(Long id) {

        Park park = parkRepository.getParkUsingId(id);

        if(park == null) {
            throw new RuntimeException("No park with id");
        }
        return park;

    }

    public List<Park> getListOfAllParks() {
        return parkRepository.findAll();
    }



}
