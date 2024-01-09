package com.nationalparkbucketlist.backend.parkcheckedservices.controller;

import com.nationalparkbucketlist.backend.parkcheckedservices.UserProxy;
import com.nationalparkbucketlist.backend.parkcheckedservices.dao.ParkCheckedRepository;
import com.nationalparkbucketlist.backend.parkcheckedservices.entity.ParkChecked;
import com.nationalparkbucketlist.backend.parkcheckedservices.services.ParkCheckedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ParkCheckedController {

    @Autowired
    private UserProxy proxy;

    @Autowired
    private ParkCheckedRepository parkCheckedRepository;

    @Autowired
    private ParkCheckedService parkCheckedService;

    @GetMapping("/getall/parkschecked")
    public List<ParkChecked> getAllParksChecked() {

        List<ParkChecked> parksChecked = parkCheckedService.returnAllTheParkChecked();

        if(parksChecked.isEmpty()) {
            throw new RuntimeException("No parks checked");
        }

        return parksChecked;
    }

    // used for testing proxy
    /*
    @GetMapping("/getwith/{username}/and/{password}")
    public List<ParkChecked> getParksCheckedMatchingUserId(@PathVariable String username, @PathVariable String password) {

        Long tempId = proxy.getIdByUserNameAndPassword(username, password);

        if(tempId == null) {
            throw new RuntimeException("No parks checked");
        }

        List<ParkChecked> myParkCheckedList = parkCheckedService.returnParksCheckedMatchingId(tempId);

        if(myParkCheckedList.isEmpty()) {
            throw new RuntimeException("No parks checked");
        }
        //List<ParkChecked> myParkCheckedList = parkCheckedRepository.findAllByUserId(tempId);
        return myParkCheckedList;
    }

     */

    @PostMapping("/parkschecked/id/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ParkChecked> createParksChecked(@PathVariable Long id){
        List<ParkChecked> checkerList = new ArrayList<ParkChecked>();

        checkerList.add(new ParkChecked("Denali", "Alaska", false, 1, id));
        checkerList.add(new ParkChecked("Gates of the Arctic", "Alaska", false, 2, id));
        checkerList.add(new ParkChecked("Glacier Bay", "Alaska", false, 3, id));
        checkerList.add(new ParkChecked("Katmai", "Alaska", false, 4, id));
        checkerList.add(new ParkChecked("Kenai Fjords", "Alaska", false, 5, id));
        checkerList.add(new ParkChecked("Kobuk Valley", "Alaska", false, 6, id));
        checkerList.add(new ParkChecked("Lake Clark", "Alaska", false, 7, id));
        checkerList.add(new ParkChecked("Wrangell - St. Elias", "Alaska", false, 8, id));
        checkerList.add(new ParkChecked("American Samoa", "American Samoa", false, 9, id));
        checkerList.add(new ParkChecked("Grand Canyon", "Arizona", false, 10, id));
        checkerList.add(new ParkChecked("Petrified Forest", "Arizona", false, 11, id));
        checkerList.add(new ParkChecked("Saguaro", "Arizona", false, 12, id));
        checkerList.add(new ParkChecked("Organ Pipe Cactus", "Arizona", false, 13, id));
        checkerList.add(new ParkChecked("Hot Springs", "Arkansas", false, 14, id));
        checkerList.add(new ParkChecked("Channel Islands", "California", false, 15, id));
        checkerList.add(new ParkChecked("Death Valley", "California", false, 16, id));
        checkerList.add(new ParkChecked("Joshua Tree", "California", false, 17, id));
        checkerList.add(new ParkChecked("Kings Canyon", "California", false, 18, id));
        checkerList.add(new ParkChecked("Lassen Volcanic", "California", false, 19, id));
        checkerList.add(new ParkChecked("Redwood", "California", false, 20, id));
        checkerList.add(new ParkChecked("Sequoia", "California", false, 21, id));
        checkerList.add(new ParkChecked("Yosemite", "California",false, 22, id));
        checkerList.add(new ParkChecked("Black Canyon of the Gunnison", "Colorado", false, 23, id));
        checkerList.add(new ParkChecked("Great Sand Dunes", "Colorado", false, 24, id));
        checkerList.add(new ParkChecked("Mesa Verde", "Colorado", false, 25, id));
        checkerList.add(new ParkChecked("Rocky Mountain", "Colorado", false, 26, id));
        checkerList.add(new ParkChecked("Biscayne", "Florida", false, 27, id));
        checkerList.add(new ParkChecked("Dry Tortugas", "Florida", false, 28, id));
        checkerList.add(new ParkChecked("Everglades", "Florida", false, 29, id));
        checkerList.add(new ParkChecked("Haleakala", "Hawaii", false, 30, id));
        checkerList.add(new ParkChecked("Hawaii Volcanoes", "Hawaii", false, 31, id));
        checkerList.add(new ParkChecked("Yellowstone", "Idaho", false, 32, id));
        checkerList.add(new ParkChecked("Mammoth Cave", "Kentucky", false, 33, id));
        checkerList.add(new ParkChecked("Isle Royale", "Michigan", false, 34, id));
        checkerList.add(new ParkChecked("Voyageurs", "Minnesota",false, 35, id));
        checkerList.add(new ParkChecked("Glacier", "Montana", false, 36, id));
        checkerList.add(new ParkChecked("Great Basin", "Nevada", false, 37, id));
        checkerList.add(new ParkChecked("Carlsbad Caverns", "New Mexico", false, 38, id));
        checkerList.add(new ParkChecked("Great Smoky Mountains", "North Carolina",false, 39, id));
        checkerList.add(new ParkChecked("Theodore Roosevelt", "North Dakota", false, 40, id));
        checkerList.add(new ParkChecked("Cuyahoga Valley", "Ohio", false, 41, id));
        checkerList.add(new ParkChecked("Crater Lake", "Oregon", false, 42, id));
        checkerList.add(new ParkChecked("'Congaree'", "South Carolina", false, 43, id));
        checkerList.add(new ParkChecked("Badlands", "South Dakota", false, 44, id));
        checkerList.add(new ParkChecked("Wind Cave", "South Dakota", false, 45, id));
        checkerList.add(new ParkChecked("Great Smoky Mountains", "Tennessee", false, 46, id));
        checkerList.add(new ParkChecked("Big Bend", "Texas", false, 47, id));
        checkerList.add(new ParkChecked("Guadalupe Mountains", "Texas", false, 48, id));
        checkerList.add(new ParkChecked("Virgin Islands", "United States Virgin Islands", false, 49, id));
        checkerList.add(new ParkChecked("Arches", "Utah", false, 50, id));
        checkerList.add(new ParkChecked("Bryce Canyon", "Utah", false, 51, id));
        checkerList.add(new ParkChecked("Canyonlands", "Utah", false, 52, id));
        checkerList.add(new ParkChecked("Capitol Reef", "Utah", false, 53, id));
        checkerList.add(new ParkChecked("Zion", "Utah", false, 54, id));
        checkerList.add(new ParkChecked("Shenandoah", "Virginia", false, 55, id));
        checkerList.add(new ParkChecked("Mount Rainier", "Washington", false, 56, id));
        checkerList.add(new ParkChecked("North Cascades", "Washington", false, 57, id));
        checkerList.add(new ParkChecked("Olympic", "Washington", false, 58, id));
        checkerList.add(new ParkChecked("Grand Teton", "Wyoming", false, 59, id));
        checkerList.add(new ParkChecked("Yellowstone", "Wyoming", false, 60, id));

        return parkCheckedService.saveAllParksChecked(checkerList);
    }


    @GetMapping("/userId/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<ParkChecked> getParkCheckedListUsingUserId(@PathVariable long id) {
        List<ParkChecked> theParkedCheckedList = new ArrayList<>();

        theParkedCheckedList = parkCheckedService.getParkCheckedListMatchingId(id);

        if(theParkedCheckedList.isEmpty()) {
            throw new RuntimeException("No park checked list matching user id");
        }

        // need to check for errors
        return theParkedCheckedList;
    }

    @PutMapping("/update/{traveled}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void updateParkChecked(@PathVariable String traveled, @RequestBody ParkChecked parkChecked) {
        ParkChecked original = parkCheckedService.getParkCheckedUsingId(parkChecked.getId());

        //System.out.println(traveled);
        original.setTraveled(Boolean.parseBoolean(traveled));



        //parkCheckedRepository.save(original);

        //System.out.println(original.getTraveled());
        parkCheckedService.postParkChecked(original);

    }

}
