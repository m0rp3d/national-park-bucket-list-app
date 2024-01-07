package com.nationalparkbucketlist.backend.parkservices.controller;

import com.nationalparkbucketlist.backend.parkservices.dao.ParkRepository;
import com.nationalparkbucketlist.backend.parkservices.entity.Park;
import com.nationalparkbucketlist.backend.parkservices.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ParkController {

    @Autowired
    private ParkRepository parkRepository;

    @Autowired
    private ParkService parkService;

    @GetMapping("/getparkby/id/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Park getParkWithParkId(@PathVariable Long id) {

        Park thePark = parkService.getParkUsingParkCheckedId(id);

        if(thePark == null) {
            throw new RuntimeException("No park with id");
        }

        return thePark;
    }

    // park checked object will pass park_id as id
    /*
    @GetMapping("getparkby/id/{id}")
    public Optional <Park> getParkWithParkCheckedId(@PathVariable Long id) {
        Optional<Park> park = parkRepository.findById(id);
        return park;
    }

     */


    @GetMapping("getall/parks")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Park> getAllParks() {
        List<Park> parks = parkService.getListOfAllParks();

        if(parks == null) {
            throw new RuntimeException("Failed to get all parks");
        }
        return parks;
    }


}
