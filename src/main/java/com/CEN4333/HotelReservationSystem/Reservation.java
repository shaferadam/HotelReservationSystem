package com.CEN4333.HotelReservationSystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int reservationNumber;
	int custId;
	int roomNumber;
	String startDate;
	String endDate;
	
	public Reservation() { }
	
	public Reservation(int reservationNumber, int custId, int roomNumber, String startDate, String endDate) {
		super();
		this.reservationNumber = reservationNumber;
		this.custId = custId;
		this.roomNumber = roomNumber;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public int getReservationNumber() {
		return reservationNumber;
	}
	
	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}
	
	public int getCustId() {
		return custId;
	}
	
	public void setCustId(int custId) {
		this.custId = custId;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public String getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Reservation [reservationNumber=" + reservationNumber + ", custId=" + custId + ", roomNumber="
				+ roomNumber + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
}
