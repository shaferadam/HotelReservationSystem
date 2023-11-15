package com.CEN4333.HotelReservationSystem;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int custId;
	private String custFirstName;
	private String custLastName;
	private String address;
	private String phoneNumber;
	private double nightlyPrice;

}
