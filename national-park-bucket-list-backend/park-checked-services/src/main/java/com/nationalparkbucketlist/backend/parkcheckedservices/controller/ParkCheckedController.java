package com.nationalparkbucketlist.backend.parkcheckedservices.controller;

import com.nationalparkbucketlist.backend.parkcheckedservices.UserProxy;
import com.nationalparkbucketlist.backend.parkcheckedservices.dao.ParkCheckedRepository;
import com.nationalparkbucketlist.backend.parkcheckedservices.entity.ParkChecked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ParkCheckedController {

    @Autowired
    private UserProxy proxy;

    @Autowired
    private ParkCheckedRepository parkCheckedRepository;

    @GetMapping("/getall/parkschecked")
    public List<ParkChecked> getAllParksChecked() {

        return parkCheckedRepository.findAll();
    }

    @GetMapping("/getwith/{username}/and/{password}")
    public List<ParkChecked> getParksCheckedMatchingUserId(@PathVariable String username, @PathVariable String password) {

        Long tempId = proxy.getIdByUserNameAndPassword(username, password);
        System.out.println("tempId is " + tempId);
        List<ParkChecked> myParkCheckedList = parkCheckedRepository.findAllByUserId(tempId);
        return myParkCheckedList;
    }

}
