package com.java.springboot.drone.lawson.service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.java.springboot.drone.lawson.medication.req.Medication;
import com.java.springboot.drone.lawson.model.DroneEntityClass;
import com.java.springboot.drone.lawson.model.DroneHistory;
import com.java.springboot.drone.lawson.model.MedicineEntity;
import com.java.springboot.drone.lawson.repository.DroneHistoryRepository;
import com.java.springboot.drone.lawson.repository.DroneRepository;
import com.java.springboot.drone.lawson.repository.MediceneRepository;

@Service
public class ServicesInterface_Implementation implements ServicesInterface {
	
	
	@Autowired
    private DroneRepository droneRepository;

    @Autowired
    private MediceneRepository medicineRepository;

    @Autowired
    DroneHistoryRepository droneHistoryRepository;



    @Override
   public DroneEntityClass registerNewDrone( DroneEntityClass newDrone) {
	   
       return droneRepository.save(newDrone);
	   
	   
   }
    @Override
  public  ResponseEntity<List<DroneEntityClass>>gettingAllDrones(){
        return  ResponseEntity.ok(droneRepository.findAll());
    	
    }
    @Override
  public  ResponseEntity<?> medication(Medication reqDrone){
    
      Optional<DroneEntityClass> drone = droneRepository.findBySerialNumber(reqDrone.getSerialNumber());
      if (!drone.isPresent())
          return new ResponseEntity<>("Not able to get the requestd drone:" + reqDrone.getSerialNumber(), HttpStatus.OK);
      if (drone.get().getBatteryCapacity() < 25)
          return new ResponseEntity<>("Battery lese than 25%:Can't load the medication", HttpStatus.OK);
      double medicationWeight = 0.0;
      for (Medication medication : reqDrone.getMedications()) {
          medicationWeight += medication.getMedicineWeight();
      }
     
      // logic for getting the drone by serial number
      
      if (medicationWeight > drone.get().getWeightLimit())
          return new ResponseEntity<>("Weight greater than expected:Can't load the medication  ", HttpStatus.OK);
      reqDrone.getMedications().forEach(medication -> {
          medication.setDrone(drone.get());
          medication = medicineRepository.save(medication);
      });
     
      //Logic that update the status of the drone
      droneRepository.save(drone.get());
      return new ResponseEntity<>("Successfully loaded the medicine", HttpStatus.OK);

    }
  
  
    @Override
  public void checkDronesBattery() {
      DroneHistory droneHistory=new DroneHistory();
      droneHistory.setInformation("check Drones Battery periodic task");
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      Date date = new Date();
      droneHistory.setDate(date);
      droneHistoryRepository .save(droneHistory);


  }
    
    
    
    
    @Override
  


  
  
  public  ResponseEntity<List<DroneHistory>>obtainingHistory(){
      return  ResponseEntity.ok( droneHistoryRepository.findAll());
  	
  }
  
  
  
  
  
  

  
  
 
   public  ResponseEntity<?> checkingMedicine(String serialNumber){
    	
        Optional<DroneEntityClass> drone = droneRepository.findBySerialNumber(serialNumber);
        if (!drone.isPresent())
            return new ResponseEntity<>("No existing drone", HttpStatus.OK);
        List<MedicineEntity> medications=medicineRepository.findAllByDrone(drone.get());
        return ResponseEntity.ok(medications);

    }
   
   
   
   public ResponseEntity<?> checkingBatteryLevel(String serialNumber){
       Optional<DroneEntityClass> drone = droneRepository.findBySerialNumber(serialNumber);
       if (!drone.isPresent())
           return new ResponseEntity<>("The drone doesn't exist: Try again:", HttpStatus.OK);
       return ResponseEntity.ok(drone.get().getBatteryCapacity());

    }




}
