package com.nagarro.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Shipping {
@Id
int pincode;
int del_time;
public Shipping() {
	super();
	//TODO Auto-generated constructor stub
}
public Shipping(int pincode, int del_time) {
	super();
	this.pincode = pincode;
	this.del_time = del_time;
}
public int getPincode() {
	return pincode;
}
public void setPincode(int pincode) {
	this.pincode = pincode;
}
public int getDel_time() {
	return del_time;
}
public void setDel_time(int del_time) {
	this.del_time = del_time;
}
@Override
public String toString() {
	return "Shipping [pincode=" + pincode + ", del_time=" + del_time + "]";
}
}
