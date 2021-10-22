package flight_reservation;

import java.util.*;
import java.time.*;
import java.time.format.*; 

public class Flight {
	int id;
	String source;
	String destination;	
	LocalDateTime departureDateTime;
	LocalDateTime arrivalDateTime;
	HashMap<String, Integer> price = new HashMap<String, Integer>();
	Plane plane;
	
	public Flight() {
		
	}
	public Flight(int id, String source, String destination, LocalDateTime departureDateTime,LocalDateTime arrivalDateTime, Integer bClassPrice, Integer fClassPrice, Integer eClassPrice, Plane plane)
	{
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.price.put("business", bClassPrice);
		this.price.put("first", fClassPrice);
		this.price.put("economy", eClassPrice);
		this.plane = plane;
	}
	
	public void printFlight()
	{
		DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");  
	    String depDT = this.departureDateTime.format(format1);
	    String arrDT = this.arrivalDateTime.format(format1);
		
	    System.out.println("Flight: " + this.id);
	    System.out.println(this.source + "-" + this.destination);
		System.out.println("Departure:\t" + depDT);
		System.out.println("Arrival:\t" + arrDT);
		
		System.out.println("Prices");
		System.out.print("Business Class: " + String.valueOf(this.price.get("business")));
		System.out.print("\tFirst Class: " + String.valueOf(this.price.get("first")));
		System.out.println("\tEconomy Class: " + String.valueOf(this.price.get("economy")));
		
		System.out.println("Seats");
		System.out.print("Business Class: " + String.valueOf(this.plane.businessClassSeats));
		System.out.print("\tFirst Class: " + String.valueOf(this.plane.firstClassSeats));
		System.out.println("\t\tEconomy Class: " + String.valueOf(this.plane.economyClassSeats));
		System.out.println();
		
	}
}
