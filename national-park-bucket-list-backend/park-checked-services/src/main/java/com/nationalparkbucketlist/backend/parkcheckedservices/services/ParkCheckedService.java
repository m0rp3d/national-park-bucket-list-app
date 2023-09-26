package com.nationalparkbucketlist.backend.parkcheckedservices.services;

import com.nationalparkbucketlist.backend.parkcheckedservices.controller.ParkCheckedController;
import com.nationalparkbucketlist.backend.parkcheckedservices.entity.ParkChecked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkCheckedService {

    @Autowired
    private ParkCheckedController parkCheckedController;

    public List<ParkChecked> returnUsersParkCheckedList(String userName, String password) {
        return parkCheckedController.getParksCheckedMatchingUserId(userName, password);
    }
}
