package flight_reservation;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) 
	{
		Scanner int_scanner = new Scanner(System.in);
		Admin admin = new Admin();
		
		try {
			readExistingFlights(admin);
			readExistingCustomers(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int option = -1;
		while(true)
		{
			printMainMenu();
			try { 
				option = int_scanner.nextInt();
			} catch (InputMismatchException e) {
				e.printStackTrace();
				int_scanner.nextLine();
				continue;
			}
			if(option == 0)
				break;
			switch (option) 
			{
				// ADMIN MENU
				case 1:{
					while(true)
					{
						printAdminMenu();
						try { 
							option = int_scanner.nextInt();
						} catch (InputMismatchException e) {
							e.printStackTrace();
							int_scanner.nextLine();
							continue;
						}
						// EXIT
						if(option == 0)
							break;
						// VIEW FLIGHTS
						else if(option == 1)
						{
							for(int i = 0; i < admin.flights.size(); i++)
							{
								admin.flights.get(i).printFlight();
							}
						}
						// ADD FLIGHT
						else if(option == 2)
						{
							
						}
						// VIEW BOOKINGS
						else if(option == 3)
						{
							
						}
						// REGISTER CUSTOMER
						else if(option == 4)
						{
							System.out.println("REGISTRATION");
							try{
								admin.register_customer();
								System.out.println("Registration Successful!");
								
							} catch (Exception e) {
								e.printStackTrace();
								int_scanner.nextLine();
							}
						}
						// INVALID INPUT
						else
						{
							
						}
					}
					break;
				}

				default:
					System.out.println("Invalid Option!");
					break;
			}
		}	 
	int_scanner.close();
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
	
	public static void readExistingCustomers(Admin admin) throws IOException, IndexOutOfBoundsException
	{
		String line = "";
		BufferedReader br = new BufferedReader(new FileReader("customers.csv"));
		
		while ((line = br.readLine()) != null)  
		{
			String[] customer_data = line.split(",");
			String login = customer_data[0];
			String password = customer_data[1];
			
			Customer customer = new Customer(login, password);
			admin.customers.add(customer);
		}
		br.close();
	}
	
	public static void readExistingFlights(Admin admin) throws IOException, IndexOutOfBoundsException
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
		br.close();
	}
}
