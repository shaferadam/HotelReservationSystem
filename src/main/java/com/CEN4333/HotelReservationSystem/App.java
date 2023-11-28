package com.CEN4333.HotelReservationSystem;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	
	static Configuration con = new Configuration().configure()
			.addAnnotatedClass(Room.class)
			.addAnnotatedClass(Customer.class);
    
    static ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    
    static SessionFactory sf = con.buildSessionFactory(reg);
                  
    static Session session = sf.openSession();
    
    static Scanner in = new Scanner(System.in);
    
	
	public static void main( String[] args ){
						
		mainMenu();  
        	
    }			
    
   
	// Menus
	
	public static void mainMenu() {
    	    	
    	System.out.println("Welcome to the Hotel Reservation system. Please choose one of the following options:  ");
    	System.out.println("1.) Add room");
    	System.out.println("2.) Display room");
    	System.out.println("3.) Delete room");
    	
    	System.out.println("4.) Add customer");
    	System.out.println("5.) Display customer");
    	System.out.println("6.) Delete customer");
    	    	    	
    	int choice = in.nextInt();
    	
    	switch(choice) {
    	
    	case 1:
    			addRoomMenu();
    			break;
    		
    	case 2:
    			displayRoomMenu();
    		
    			break;
    	
    	case 3:
    			deleteRoomMenu();
    			break;
    	
    	case 4:
    		
    			addCustomerMenu();
    			break;
    			
    	case 5:
    			System.out.println("To do");
    			mainMenu();
    			break;
    		
    	case 6:
    			System.out.println("To do");
    			mainMenu();
    			break;
    	
    	default:
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
        	
    public static void deleteRoomMenu() {
    	
    	System.out.println("Please enter the room number of the room to be deleted.");
    	
    	int roomNumber = in.nextInt();
    	
    	deleteRoom(roomNumber);
    	
    	System.out.println("Room number " + roomNumber + " has been deleted.");
    	   	    	    	
    }
        
    public static void displayRoomMenu() {
    	
    	in.nextLine();
    	
    	System.out.println("Please enter the room number or type 0 to display all rooms");
    	
    	int choice = in.nextInt();
    	
    	switch(choice) {
    	
    	case 0:
    			displayAllRooms();
    			break;    	   	
    	
    	default:
    				displayRoom(choice);
    	}   	  	    	    	    	    	
    	
    	  	    	
    	mainMenu();   	
    }

    public static void addCustomerMenu() {
    	
    	in.nextLine();
    	
    	System.out.println("Please enter the customer's first name: ");
    	
    	String custFirstName = in.nextLine();
    	  	    	    	    	    	
    	System.out.println("Please enter the customer's last name: ");
    	
    	String custLastName = in.nextLine();
    	
    	System.out.println("Please enter the customer's address: ");
    	
    	String address = in.nextLine(); 
    	
    	System.out.println("Please enter the customer's phone number: ");
    	
    	String phoneNumber = in.nextLine(); 
    	
    	addCustomer(custFirstName,custLastName,address,phoneNumber);
    	 
    	System.out.println("The customer has been added."); 
    	  	    	
    	mainMenu();   	
    	
    }
    
   
    // Methods
    
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
        
    public static void addCustomer(String custFirstName, String custLastname, String address, String phoneNumber) {
    	
    	Customer customer1 = new Customer();
    	
    	customer1.setCustFirstName(custFirstName);
    	customer1.setCustLastName(custLastname);
    	customer1.setAddress(address);
    	customer1.setPhoneNumber(phoneNumber);
    	                        
        Transaction tx = session.beginTransaction();
        
        session.save(customer1);
        
        tx.commit();
    }
    
    public static void displayAllRooms() {
    	
    	Query q = session.createQuery("from Room");
    	    	    	
    	List<Room> rooms= q.list();  
    	
    	System.out.println("Here is a list of all of the rooms:\n");
    	    	    	
    	for (int i = 0; i < rooms.size(); i++)
    	{     	
    	System.out.println("Room Number: " + rooms.get(i).getRoomNumber());
    	System.out.println("Floor: " + rooms.get(i).getFloor());
    	System.out.println("Bed Type: " + rooms.get(i).getBedType());
    	System.out.println("Available: " + rooms.get(i).isAvailable());
    	System.out.println("");
    	}
    	
    	mainMenu();
    	
    }
        
    public static void displayRoom(int roomNumber) {   
    	
    	Query q = session.createQuery("from Room where roomNumber =" + roomNumber);
    	    	    	
    	List<Room> rooms= q.list();    	    	    	
    	
    	System.out.println("Room Id: " + rooms.get(0).getRoomId());
    	System.out.println("Room Number: " + rooms.get(0).getRoomNumber());
    	System.out.println("Floor: " + rooms.get(0).getFloor());
    	System.out.println("Bed Type: " + rooms.get(0).getBedType());
    	System.out.println("Available: " + rooms.get(0).isAvailable());
    	System.out.println("");
    	
    	mainMenu();
        	    	
    }
    
    
    // This method isn't working.  It says it deletes the record but when you check the database it is still there.
    public static void deleteRoom(int roomNumber) {
    	
    	Session session1 = sf.openSession();
    	
    	Transaction tx1 = session1.beginTransaction();
    	
    	Query q1 = session1.createQuery("from Room where roomNumber =" + roomNumber);
    	
    	// System.out.println(q1.toString());
    	
    	List<Room> rooms = q1.list();  
    	
    	System.out.println(rooms.toString());
    	
    	int roomID = rooms.get(0).getRoomId();
    	
    	System.out.println(roomID);
    	
    	tx1.commit();
    	
    	
    	try {
    		
    		Transaction tx2 = session1.beginTransaction();
	    	
        	// String q2String = "delete Room where roomId=1";
        	
        	SQLQuery q2 = session.createSQLQuery("delete from Room where roomId = " + 1);
        	
        	// Query q2 = session1.createQuery(q2String);        	
        	    	   	    	
        	int count = q2.executeUpdate();
        	
        	System.out.println(count + " Records Deleted");
        	    	    	
        	tx2.commit();
    		
    	}  catch(Exception e) {e.printStackTrace(); }
    	
    	finally { 
    		
    		session1.clear();
        	
        	session1.close(); 
    		
    	}      	
    	    	
    	mainMenu();
       			
    	
    }
       
  }
