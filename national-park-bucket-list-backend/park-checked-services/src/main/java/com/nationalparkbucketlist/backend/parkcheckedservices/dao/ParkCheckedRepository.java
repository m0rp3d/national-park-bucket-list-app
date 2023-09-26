package com.nationalparkbucketlist.backend.parkcheckedservices.dao;

import com.nationalparkbucketlist.backend.parkcheckedservices.entity.ParkChecked;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkCheckedRepository extends JpaRepository<ParkChecked, Long> {


    List<ParkChecked> findAllByUserId(Long userId);


}
