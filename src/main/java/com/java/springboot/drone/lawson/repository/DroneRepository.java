package com.java.springboot.drone.lawson.repository;


import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.springboot.drone.lawson.model.DroneEntityClass;

@Repository
public interface DroneRepository extends JpaRepository<DroneEntityClass, Long>{


	Optional<DroneEntityClass> findBySerialNumber(String serialNumber);

}
