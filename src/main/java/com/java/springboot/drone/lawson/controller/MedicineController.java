package com.java.springboot.drone.lawson.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.springboot.drone.lawson.model.MedicineEntity;
import com.java.springboot.drone.lawson.repository.MediceneRepository;


import jakarta.validation.Valid;

@RestController
//@RequestMapping("/rest-api/")
public class MedicineController {

	// saving the medication
	@Autowired
	private MediceneRepository medicineReposotory;
	
	 @PostMapping("/medication")
	 
	 MedicineEntity newMedicine( @RequestBody MedicineEntity newMedication) {
			return 	  medicineReposotory.save(newMedication);
	 }
	 /*
	   public ResponseEntity<?> addMedicine(@Valid @RequestBody MedicineEntity saveMedicine) {
	   	MedicineEntity save = medicineReposotory.save(saveMedicine);
	       return new ResponseEntity<>( save,HttpStatus.CREATED);
	   }*/
	
	 
	 @GetMapping("med")
		List<MedicineEntity> getMedication(){
			return  medicineReposotory.findAll();
		}
}
