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
			.addAnnotatedClass(Customer.class)
			.addAnnotatedClass(Reservation.class);
    
    static ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
    
    static SessionFactory sf = con.buildSessionFactory(reg);
           
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
    	System.out.println("7.) Add reservation");
    	    	    	
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
    			displayCustomerMenu();
    			break;
    		
    	case 6:
    			deleteCustomerMenu();
    			break;
    			
    	case 7:
			addReservationMenu();
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
    
    public static void addReservationMenu() {
    	
    	in.nextLine();
    	
    	System.out.println("Please enter the customer's telephone number: ");
    	
    	String custPhoneNumber = in.nextLine();
    	  	    	    	    	    	
    	System.out.println("Please enter the room number:");
    	
    	int roomNumber = in.nextInt();
    	
    	in.nextLine();
    	
    	System.out.println("Please enter the reservation start date: ");
    	
    	String startDate = in.nextLine(); 
    	
    	System.out.println("Please enter the reservation end date: ");
    	    	    	
    	String endDate= in.nextLine(); 
    	
    	addReservation(custPhoneNumber, roomNumber, startDate, endDate);
    	 
    	System.out.println("The reservation has been added."); 
    	  	    	
    	mainMenu();   	
    	
    }
    
    public static void displayCustomerMenu() {
    	
    	in.nextLine();
    	
    	System.out.println("Please enter Customer Phone Number to look up customer: ");
    	
    	String choice = in.nextLine();
    	
    	displayCustomer(choice);
    }
    
   
    // Methods
    public static void addRoom(int roomNumber,int floor,String bedtype, double nightlyPrice) {
    	Room room1 = new Room();
    	
    	Session session1 = sf.openSession();
    	
    	room1.setRoomNumber(roomNumber);
    	room1.setFloor(floor);
    	room1.setBedType(bedtype);
    	room1.setNightlyPrice(nightlyPrice);
                        
        Transaction tx = session1.beginTransaction();
        
        session1.save(room1);
        
        tx.commit();
    }
        
    public static void addCustomer(String custFirstName, String custLastname, String address, String phoneNumber) {
    	
    	Session session1 = sf.openSession();
    	
    	Customer customer1 = new Customer();
    	  	
    	customer1.setCustFirstName(custFirstName);
    	customer1.setCustLastName(custLastname);
    	customer1.setAddress(address);
    	customer1.setPhoneNumber(phoneNumber);
    	                        
        Transaction tx = session1.beginTransaction();
        
        session1.save(customer1);
        
        tx.commit();
    }
       
    public static void addReservation(String customerPhoneNumber, int roomNumber, String startDate, String endDate){
    	
    	Session session1 = sf.openSession();
    	
		Query q1 = session1.createQuery("from Customer where phoneNumber = '" + customerPhoneNumber + "'");
	    	    	
		List<Customer> customers= q1.list();
		
		int custId = customers.get(0).getCustId();
			
		session1.close();
		
		
		Session session2 = sf.openSession();
    	
		Query q2 = session2.createQuery("from Room where roomNumber = '" + roomNumber + "'");
	    	    	
		List<Room> rooms = q2.list();
		
		int roomId = rooms.get(0).getRoomId();
			
		session2.close();
		
		
		Session session3 = sf.openSession();
    	
    	Reservation reservation1 = new Reservation();
    	    	   	
    	reservation1.setCustomerId(custId);
    	reservation1.setRoomId(roomId);
    	reservation1.setStartDate(startDate);
    	reservation1.setEndDate(endDate);
    	                        
        Transaction tx = session3.beginTransaction();
        
        session3.save(reservation1);
        
        tx.commit();
	
		mainMenu();	    	
	}
      
    public static void displayAllRooms() {
    	
    	Session session1 = sf.openSession();
    	
    	Query q = session1.createQuery("from Room");
    	    	    	
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
    	session1.close();
    	
    	mainMenu();
    	
    }
        
    public static void displayRoom(int roomNumber) {   
    	
    	Session session1 = sf.openSession();
    	
    	Query q = session1.createQuery("from Room where roomNumber =" + roomNumber);
    	    	    	
    	List<Room> rooms= q.list();    	    	    	
    	
    	System.out.println("Room Id: " + rooms.get(0).getRoomId());
    	System.out.println("Room Number: " + rooms.get(0).getRoomNumber());
    	System.out.println("Floor: " + rooms.get(0).getFloor());
    	System.out.println("Bed Type: " + rooms.get(0).getBedType());
    	System.out.println("Available: " + rooms.get(0).isAvailable());
    	System.out.println("");
    	
    	session1.close();
    	
    	mainMenu();
        	    	
    }
            
    public static void deleteRoom(int roomNumber) {
    	
    	Session session1 = sf.openSession();
    	
    	Transaction tx1 = session1.beginTransaction();
    	
    	Query q1 = session1.createQuery("from Room where roomNumber =" + roomNumber);
    	
    	// System.out.println(q1.toString());
    	
    	List<Room> rooms = q1.list();  
    	    	
    	int roomID = rooms.get(0).getRoomId();    
    	
    	tx1.commit();
    	
    	session1.close();
    	
    	Session session2 = sf.openSession();
    	
    	
    	try {
    		
    		Transaction tx2 = session2.beginTransaction();
	    	
        	String q2String = "delete Room where roomId=" + roomID;
        	        	
        	Query q2 = session2.createQuery(q2String);        	
        	    	   	    	
        	int count = q2.executeUpdate();
        	
        	System.out.println(count + " Records Deleted");
        	    	    	
        	tx2.commit();
        	        	
    		
    	}  catch(Exception e) {e.printStackTrace(); }
    	
    	finally { 
    		    	
    		session2.flush();
    		
        	session2.close(); 
        	
        	mainMenu();
    		
    	}          			  	
    }
       
    public static void displayCustomer(String customerPhoneNumber) {   
    	
		Session session1 = sf.openSession();
	
		Query q = session1.createQuery("from Customer where phoneNumber = '" + customerPhoneNumber + "'");
	    	    	
		List<Customer> customers= q.list();  
		
		System.out.println(customers.toString());
		
		System.out.println("");
		System.out.println("customer Id: " + customers.get(0).getCustId());
		System.out.println("First Name: " + customers.get(0).getCustFirstName());
		System.out.println("Last Name: " + customers.get(0).getCustLastName());
		System.out.println("Phone Number: " + customers.get(0).getPhoneNumber());
		System.out.println("");
		
	
		session1.close();
	
		mainMenu();	    	
	}
    
    public static void deleteCustomerMenu() {
    	
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("Please enter the customer phone number of customer to be deleted.");
    	
    	String custPhoneNumber = scanner.nextLine();
    	
    	deleteCustomer(custPhoneNumber);
    	
    	System.out.println("Customer with phone number " + custPhoneNumber + " has been deleted.");
    	   	    	    	
    }
    
    public static void deleteCustomer(String custPhoneNumber) {
    	
    	Session session1 = sf.openSession();
    	
    	Transaction tx1 = session1.beginTransaction();
    	
    	Query q1 = session1.createQuery("from Customer where phoneNumber =" + custPhoneNumber);
    	    	    	
    	List<Customer> customers = q1.list();  
    	    	
    	String phoneNumber = customers.get(0).getPhoneNumber();    
    	
    	tx1.commit();
    	
    	session1.close();
    	
    	Session session2 = sf.openSession();
    	
    	
    	try {
    		
    		Transaction tx2 = session2.beginTransaction();
	    	
        	String q2String = "delete Customer where phoneNumber=" + phoneNumber;
        	        	
        	Query q2 = session2.createQuery(q2String);        	
        	    	   	    	
        	int count = q2.executeUpdate();
        	
        	System.out.println(count + " Records Deleted");
        	    	    	
        	tx2.commit();
        	        	
    		
    	}  catch(Exception e) {e.printStackTrace(); }
    	
    	finally { 
    		    	
    		session2.flush();
    		
        	session2.close(); 
        	
        	mainMenu();
    		
    	}          			  	
    }
}
