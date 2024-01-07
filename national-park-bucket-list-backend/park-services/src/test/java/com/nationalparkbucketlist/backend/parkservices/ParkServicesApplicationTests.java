package com.nationalparkbucketlist.backend.parkservices;

import com.nationalparkbucketlist.backend.parkservices.controller.ParkController;
import com.nationalparkbucketlist.backend.parkservices.entity.Park;
import com.nationalparkbucketlist.backend.parkservices.service.ParkService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ParkServicesApplicationTests {

    @Autowired
    private ParkService parkService;

    @Autowired
    private ParkController parkController;


    @Test
    public void testGetParkById() {
        Long tempId = Long.valueOf(3);

        Park park = parkController.getParkWithParkId(tempId);

        assertEquals("Glacier Bay", park.getParkName());
    }





    // should throw exception when value is out of bound of 1-60
    @Test
    public void willThrowWhenNoParkMatching() {
        Long tempId = Long.valueOf(89);

        assertThatThrownBy(() -> parkController.getParkWithParkId(tempId))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("No park with id");
    }


}
