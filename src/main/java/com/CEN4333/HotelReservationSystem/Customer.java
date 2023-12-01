package com.CEN4333.HotelReservationSystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer 
{
		
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custId;
	private String custFirstName;
	private String custLastName;
	private String address;
	private String phoneNumber;
	
			
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getCustFirstName() {
		return custFirstName;
	}
	public void setCustFirstName(String custFirstName) {
		this.custFirstName = custFirstName;
	}
	public String getCustLastName() {
		return custLastName;
	}
	public void setCustLastName(String custLastName) {
		this.custLastName = custLastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custFirstName=" + custFirstName + ", custLastName=" + custLastName
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
}
