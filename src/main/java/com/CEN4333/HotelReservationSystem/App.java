package com.CEN4333.HotelReservationSystem;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	static Configuration con = new Configuration().configure().addAnnotatedClass(Room.class);
    
    static ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    
    static SessionFactory sf = con.buildSessionFactory(reg);
                  
    static Session session = sf.openSession();
    
    static Scanner in = new Scanner(System.in);
    
	
	public static void main( String[] args ){
				
    	mainMenu();        	       
    }
    
    public static void mainMenu() {
    	    	
    	System.out.println("Welcome to the Hotel Reservation system. Please choose one of the following options:  ");
    	System.out.println("1.) Add room");
    	System.out.println("2.) Display room");
    	System.out.println("3.) Delete room");
    	    	    	
    	int choice = in.nextInt();
    	
    	if (choice == 1)
    	{
    		addRoomMenu();
    	}
    	
    	if (choice ==2)
    	{
    		System.out.println("Please enter the room number for the room:");
    		
    		int roomID = in.nextInt();
    		
    		getRoom(roomID);
    	}
    	
    	else
    	{
    		mainMenu();
    	}
    	
    	    
    }
    
    public static void addRoomMenu() {
    	
    	
    	System.out.println("Please enter the room number: ");
    	
    	int roomNumber = in.nextInt();
    	
    	in.nextLine();
    	    	    	    	
    	System.out.println("Please enter the floor: ");
    	
    	int floor = in.nextInt();
    	
    	in.nextLine();
    	
    	System.out.println("Please enter the bed type: ");
    	
    	String bedType = in.nextLine(); //
    	
    	System.out.println("Please enter the nightly price: ");
    	
    	double nightlyPrice = in.nextDouble();
    	
    	addRoom(roomNumber,floor,bedType,nightlyPrice);
    	 
    	System.out.println("The room has been added."); 
    	   	
    	
    	mainMenu();   	
    	
    }
    
    public static void addRoom(int roomNumber,int floor,String bedtype, double nightlyPrice) {
    	Room room1 = new Room();
    	
    	room1.setRoomNumber(roomNumber);
    	room1.setFloor(floor);
    	room1.setBedType(bedtype);
    	room1.setNightlyPrice(nightlyPrice);
                        
        Transaction tx = session.beginTransaction();
        
        session.save(room1);
        
        tx.commit();
    }
    
    public static void getRoom(int roomNumber) {   
    	
    	Query q = session.createQuery("from Room where roomNumber =" + roomNumber);
    	
    	System.out.println(q.toString());
    	
    	List<Room> rooms= q.list();    	    	    	
    	
    	System.out.println("Room Id: " + rooms.get(0).getRoomId());
    	System.out.println("Room Number: " + rooms.get(0).getRoomNumber());
    	System.out.println("Floor: " + rooms.get(0).getFloor());
    	System.out.println("Bed Type: " + rooms.get(0).getBedType());
    	System.out.println("Available: " + rooms.get(0).isAvailable());
    	System.out.println("");
    	
    	mainMenu();
        	    	
    }
     
  }
