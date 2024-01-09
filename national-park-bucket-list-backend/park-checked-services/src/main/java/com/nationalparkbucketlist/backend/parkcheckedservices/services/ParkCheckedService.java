package com.nationalparkbucketlist.backend.parkcheckedservices.services;

import com.nationalparkbucketlist.backend.parkcheckedservices.controller.ParkCheckedController;
import com.nationalparkbucketlist.backend.parkcheckedservices.dao.ParkCheckedRepository;
import com.nationalparkbucketlist.backend.parkcheckedservices.entity.ParkChecked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkCheckedService {

    @Autowired
    private ParkCheckedRepository parkCheckedRepository;

    public List<ParkChecked> returnAllTheParkChecked() {
        return parkCheckedRepository.findAll();
    }

    public List<ParkChecked> returnParksCheckedMatchingId(Long id) {
        return parkCheckedRepository.findAllByUserId(id);
    }

    public List<ParkChecked> saveAllParksChecked(List<ParkChecked> parksChecked) {
        return parkCheckedRepository.saveAll(parksChecked);
    }

    public List<ParkChecked> getParkCheckedListMatchingId(Long id) {
        List<ParkChecked> usersParkCheckedList = new ArrayList<>();
        try{
            usersParkCheckedList = parkCheckedRepository.findAllByUserId(id);
        } catch (Exception e) {
            System.out.println("No id matching the passed parameter");
        }
        return usersParkCheckedList;
    }

    public ParkChecked getParkCheckedUsingId(Long id) {
        return parkCheckedRepository.findById(id).get();
    }

    public void postParkChecked(ParkChecked parkChecked) {
        parkCheckedRepository.save(parkChecked);
    }

    /*
    @Autowired
    private ParkCheckedController parkCheckedController;

    public List<ParkChecked> returnUsersParkCheckedList(String userName, String password) {
        return parkCheckedController.getParksCheckedMatchingUserId(userName, password);
    }

     */
}
