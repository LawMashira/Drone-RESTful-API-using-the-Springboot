package com.java.springboot.drone.lawson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.drone.lawson.model.DroneHistory;
@Repository
public interface DroneHistoryRepository extends JpaRepository< DroneHistory,Long> {

}
