package com.java.springboot.drone.lawson.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.drone.lawson.medication.req.Medication;
import com.java.springboot.drone.lawson.model.DroneEntityClass;
import com.java.springboot.drone.lawson.model.MedicineEntity;

@Repository
public interface MediceneRepository extends JpaRepository<MedicineEntity,Long> {


	List<MedicineEntity> findAllByDrone(DroneEntityClass droneEntityClass);

	Medication save(Medication medication);


}
