package com.java.springboot.drone.lawson.medication.req;

import java.util.List;

import com.java.springboot.drone.lawson.model.DroneEntityClass;

public class Medication {
	
	 private String serialNumber;
	   private List<Medication>medicines;

	    public String getSerialNumber() {
	        return serialNumber;
	    }

	    public void setSerialNumber(String serialNumber) {
	        this.serialNumber = serialNumber;
	    }

	    public List<Medication> getMedications() {
	        return medicines;
	    }

	    public void setMedications(List<Medication> medicines) {
	        this.medicines= medicines;
	    }

		public void setDrone(DroneEntityClass droneEntityClass) {
			
			
		}

		public double getMedicineWeight() {
			
			return 0;
		}

	
	

}
