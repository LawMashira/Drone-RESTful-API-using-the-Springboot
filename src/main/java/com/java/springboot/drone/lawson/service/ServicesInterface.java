package com.java.springboot.drone.lawson.service;

import java.util.List;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.java.springboot.drone.lawson.medication.req.Medication;
import com.java.springboot.drone.lawson.model.DroneEntityClass;


public interface ServicesInterface {
	
	DroneEntityClass registerNewDrone( DroneEntityClass newDrone);
    ResponseEntity<List<DroneEntityClass>>gettingAllDrones();
     ResponseEntity<?> medication(Medication request);
    ResponseEntity<?> checkingMedicine(String serialNumber);
    ResponseEntity<?> checkingBatteryLevel(String serialNumber);


    void checkDronesBattery();
    
    ResponseEntity<?>obtainingHistory();

	
	

}
