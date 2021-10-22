package flight_reservation;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) 
	{
		Scanner int_scanner = new Scanner(System.in);
		Admin admin = new Admin();
		
		try {
			readDefaultFlights(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true)
		{
			printMainMenu();
			int option = int_scanner.nextInt();
			if(option == 0)
				break;
			switch (option) 
			{
				case 1:{
					while(true)
					{
						printAdminMenu();
						option = int_scanner.nextInt();
						if(option == 0)
							break;
					}
					break;
				}

				default:
					break;
			}
		}
		 
		 
		
	}
	
	public static void printMainMenu()
	{
		System.out.println("Select option:");
		System.out.println("1:\tContinue as Admin");
		System.out.println("2:\tLog in as User");
		System.out.println("0:\tExit");
	}
	
	public static void printAdminMenu()
	{
		System.out.println("Select option:");
		System.out.println("1:\tView flights");
		System.out.println("2:\tAdd Flight");
		System.out.println("3:\tView Bookings");
		System.out.println("4:\tRegister Customer");
		System.out.println("0:\tExit");
	}
	
	public static void printCustomerMenu()
	{
		System.out.println("Select option:");
		System.out.println("1:\tView my Bookings");
		System.out.println("2:\tBook Flight");
		System.out.println("3:\tSearch Flights");
		System.out.println("0:\tExit");
	}
	
	public static void readDefaultFlights(Admin admin) throws IOException, IndexOutOfBoundsException
	{
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader("flights.csv"));
		
		br.readLine(); // SKIPS FIRST LINE
		while ((line = br.readLine()) != null)  
		{  
			String[] flight_data = line.split(",");
			String source = flight_data[0];
			String dest = flight_data[1];
			
			int dYear = Integer.parseInt(flight_data[2]);
			int dMonth = Integer.parseInt(flight_data[3]);
			int dDay = Integer.parseInt(flight_data[4]);
			LocalDate date = LocalDate.of(dYear, dMonth, dDay);
			
			int dHour = Integer.parseInt(flight_data[5]);
			int dMin = Integer.parseInt(flight_data[6]);
			LocalTime time = LocalTime.of(dHour, dMin);
			LocalDateTime depDT = LocalDateTime.of(date, time);
			
			int aYear = Integer.parseInt(flight_data[7]);
			int aMonth = Integer.parseInt(flight_data[8]);
			int aDay = Integer.parseInt(flight_data[9]);
			date = LocalDate.of(aYear, aMonth, aDay);
			
			int aHour = Integer.parseInt(flight_data[10]);
			int aMin = Integer.parseInt(flight_data[11]);
			time = LocalTime.of(aHour, aMin);
			LocalDateTime arrDT = LocalDateTime.of(date, time);
			
			int bPrice = Integer.parseInt(flight_data[12]);
			int fPrice = Integer.parseInt(flight_data[13]);
			int ePrice = Integer.parseInt(flight_data[14]);
			
			int bSeats = Integer.parseInt(flight_data[15]);
			int fSeats = Integer.parseInt(flight_data[16]);
			int eSeats = Integer.parseInt(flight_data[17]);
			
			Plane plane = new Plane(bSeats, fSeats, eSeats);
			int id = admin.flights.size() + 1;
			Flight flight = new Flight(id, source, dest, depDT, arrDT, bPrice, fPrice, ePrice, plane);
			admin.flights.add(flight);
		} 
	}
}
