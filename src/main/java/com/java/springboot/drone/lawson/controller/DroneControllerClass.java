package com.java.springboot.drone.lawson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.springboot.drone.lawson.medication.req.Medication;
import com.java.springboot.drone.lawson.model.DroneEntityClass;
import com.java.springboot.drone.lawson.repository.DroneRepository;
import com.java.springboot.drone.lawson.service.ServicesInterface;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest-api/")
@Validated
public class DroneControllerClass {
	
	
	
	@Autowired
	
	 private ServicesInterface  servicesInterface ;
	@Autowired 
	private DroneRepository droneRepository;
  
  //Here we are registering the drone in the database
	
   @PostMapping("register")
   
   public ResponseEntity<?> registerDrone(@Valid @RequestBody DroneEntityClass drone) {
   	DroneEntityClass savedDrone = servicesInterface.registerNewDrone(drone);
       return new ResponseEntity<DroneEntityClass>( savedDrone,HttpStatus.CREATED);
   }


   @GetMapping("gettingdrones")
   public ResponseEntity<?>gettingAllDrones() {
       return  servicesInterface.gettingAllDrones();
   }




  


   //this is for loading medicines
   
   @PostMapping("loading-medicines")
   
   public ResponseEntity<?> loadMedications(@Valid @RequestBody Medication req) {
       return   servicesInterface.medication(req);
   }


   //checking medicines
   
   @GetMapping("getting-medicines")
   public ResponseEntity<?> checkingMedicine(@RequestParam("droneSerialNo") String droneSerialNo) {
       return  servicesInterface.checkingMedicine(droneSerialNo);
   }

   

  
   //Checking the battery of a drone
   
   @GetMapping("checkingbattery")
   
   public ResponseEntity<?> checkingBatteryLevel(@Valid @RequestParam("droneNumber") String droneNumber) {
       return  servicesInterface.checkingBatteryLevel(droneNumber);
   }

	
	
	

	
	
	

}
