package com.CEN4333.HotelReservationSystem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Room
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int roomId;
	private int roomNumber;
	private int floor;
	private String bedType;
	private boolean isAvailable;
	private double nightlyPrice;
	
		
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getFloor() {
		return floor;
	}
	public void setFloor(int floor) {
		this.floor = floor;
	}
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public double getNightlyPrice() {
		return nightlyPrice;
	}
	public void setNightlyPrice(double nightlyPrice) {
		this.nightlyPrice = nightlyPrice;
	}
	
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomNumber=" + roomNumber + ", floor=" + floor + ", bedType=" + bedType
				+ ", isAvailable=" + isAvailable + ", nightlyPrice=" + nightlyPrice + "]";
	}
						
}
