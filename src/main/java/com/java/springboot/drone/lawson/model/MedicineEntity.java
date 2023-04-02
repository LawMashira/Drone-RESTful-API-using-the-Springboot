package com.java.springboot.drone.lawson.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Pattern;
@Entity
public class MedicineEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	//Allowing only '-','_',letters,numbers
   // @Pattern(regexp = "^[a-z A-Z 0-9]- _",message="Allowing only '-','_',letters,numbers")
	private String name;
    
	private double medicineWeight;
	
	//Allowing only '_',capital letters & numbers
	//@Pattern(regexp = "^[ A-Z 0-9]_-",message="Allowing only '_',capital letters & numbers")
	private String code;
	
	//private byte[] medicineImage;
	
	
	public MedicineEntity() {
		super();
	}

	@ManyToOne
    @JoinColumn(name="droneID")
    @JsonIgnore
    private DroneEntityClass drone;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getMedicineWeight() {
		return medicineWeight;
	}


	public void setMedicineWeight(double medicineWeight) {
		this.medicineWeight = medicineWeight;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	/*public byte[] getMedicineImage() {
		return medicineImage;
	}


	public void setMedicineImage(byte[] medicineImage) {
		this.medicineImage = medicineImage;
	}*/
	/*
	 public DroneEntityClass getDrone() {
			return drone;
		}


		public void setDrone(DroneEntityClass drone) {
			this.drone = drone;
		}*/

}
