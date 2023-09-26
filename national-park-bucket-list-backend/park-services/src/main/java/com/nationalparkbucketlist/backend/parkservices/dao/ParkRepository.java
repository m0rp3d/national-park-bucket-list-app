package com.nationalparkbucketlist.backend.parkservices.dao;

import com.nationalparkbucketlist.backend.parkservices.entity.Park;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParkRepository extends JpaRepository<Park, Long> {

    @Query(value = "SELECT * FROM Park p where p.id = :id", nativeQuery = true)
    public Park getParkUsingId(@Param("id") Long id);
}
