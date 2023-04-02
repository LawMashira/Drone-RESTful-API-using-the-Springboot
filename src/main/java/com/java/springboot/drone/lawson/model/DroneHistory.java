package com.java.springboot.drone.lawson.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class DroneHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long ID;
	
private String information;
private Date date;
public DroneHistory() {
	super();
}
public Long getID() {
	return ID;
}
public void setID(Long iD) {
	ID = iD;
}
public String getInformation() {
	return information;
}
public  void setInformation(String information) {
this.information= information;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}


	
}
