package com.java.springboot.drone.lawson.model;

import java.util.List;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
	@Entity
	public class DroneEntityClass {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		
		private Long id;
		
		//Maximum of 100 characters only
		@NotEmpty
		@Size(max=100, message="Maximum of characters only")
		private String serialNumber;
		@NotEmpty
		private String modelType;
		//@NotEmpty
		@Range(min=(long) 0.0 ,max= (long)500.0, message="Maximum of 500 grammes  only" )
		private double weightLimit;
		
		@Size(min=25,message="Battery is less than 25% cant perform the task")
		private int batteryCapacity;
		
		private String state;
		
		
		public DroneEntityClass() {
			super();
		}

		public DroneEntityClass(Long id, String serialNumber, String modelType, double weightLimit, int batteryCapacity,
				String state, List<MedicineEntity> medicine) {
			super();
			
			
			this.id = id;
			this.serialNumber = serialNumber;
			this.modelType = modelType;
			this.weightLimit = weightLimit;
			this.batteryCapacity = batteryCapacity;
			this.state = state;
			this.medicine=medicine;
		}







	    @OneToMany(targetEntity = MedicineEntity.class,cascade=CascadeType.ALL)
	    @JoinColumn(name="code",referencedColumnName ="id")
	    
	    private List<MedicineEntity>medicine;
	   

		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getSerialNumber() {
			return serialNumber;
		}


		public void setSerialNumber(String serialNumber) {
			this.serialNumber = serialNumber;
		}


		public String getModelType() {
			return modelType;
		}


		public void setModelType(String modelType) {
			this.modelType = modelType;
		}


		public double getWeightLimit() {
			
			return weightLimit;
		}


		public void setWeightLimit( double weightLimit) {
			this.weightLimit = weightLimit;
		}


		public int getBatteryCapacity() {
			return batteryCapacity;
		}


		public void setBatteryCapacity(int batteryCapacity) {
			this.batteryCapacity = batteryCapacity;
		}


		public String getState() {
			return state;
		}


		public void setState(String state) {
			this.state = state;
		}
		
		 
			public List<MedicineEntity> getMedicine() {
				return medicine;
			}

			public void setMedicine(List<MedicineEntity> medicine) {
				this.medicine = medicine;
			}

			public void setDrone(DroneEntityClass droneEntityClass) {
				
				
			}

			public double getMedicineWeight() {
				
				return 0;
			}
		
		
		
	}

	
	

																										