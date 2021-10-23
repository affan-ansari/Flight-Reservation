package flight_reservation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Booking {
	String id;
	Vector<Ticket> tickets;
	Flight flight;
	
	public Booking(String id) {
		this.tickets = new Vector<Ticket>();
		this.id = id;
	}
	
	public Invoice generate_invoice()
	{
		Invoice inv = new Invoice(this);
		inv.calculateBill();
		return inv;
	}
	
	public void print_tickets() throws IOException
	{
		for(int i = 0; i < this.tickets.size(); i++)
		{
			Ticket t1 = this.tickets.get(i);
			String filename = this.id + " Ticket" + String.valueOf(i+1) + ".txt";
			FileWriter pw = new FileWriter(filename);
			pw.append("Booking ID: " + this.id);
			pw.append("\nClass:\t\t" + t1.classType);
			pw.append("\nSeat No:\t" + t1.seatNo);
			pw.append("\nName: " + t1.passenger.name);
			pw.append("\nGender: " + t1.passenger.gender);
			pw.append("\tAge: " + t1.passenger.age);
			pw.append("\nPassport: " + t1.passenger.passportNumber);
			pw.close();
		}
	}
	
	public void generate_tickets()
	{
		Scanner sc = new Scanner(System.in);
		int option = -1;
		
		System.out.println("Selected Flight:");
		this.flight.printFlight();
		do {
			System.out.println("Select class:");
			String selected_class = this.select_flight_class();
			if(selected_class.equals("invalid"))
			{
				System.out.println("Invalid option selected");
				continue;
			}
			
			Passenger passenger = this.create_passenger();
			String seat_no = "";
			if(selected_class.equals("business"))
			{
				seat_no = "B" + String.valueOf(this.flight.plane.businessClassSeats);
				this.flight.plane.businessClassSeats--;
			}
			else if(selected_class.equals("first"))
			{
				seat_no = "F" + String.valueOf(this.flight.plane.firstClassSeats);
				this.flight.plane.firstClassSeats--;
			}
			else if(selected_class.equals("economy"))
			{
				seat_no = "E" + String.valueOf(this.flight.plane.economyClassSeats);
				this.flight.plane.economyClassSeats--;
			}
			
			Ticket t1 = new Ticket(seat_no, passenger, selected_class);
			this.tickets.add(t1);
			
			System.out.println("Do you want another ticket?");
			System.out.println("1: Yes");
			System.out.println("Any other key to exit");
			option = sc.nextInt();
			
		} while (option == 1);
	}
	
	private Passenger create_passenger()
	{
		Scanner str_scanner = new Scanner(System.in);
		
		System.out.print("Name: ");
		String name = str_scanner.nextLine();
		System.out.print("Gender: ");
		String gender = str_scanner.nextLine();
		System.out.print("Age: ");
		int age = Integer.parseInt(str_scanner.nextLine());
		System.out.print("Address: ");
		String address = str_scanner.nextLine();
		System.out.print("Phone number: ");
		String phone_num = str_scanner.nextLine();
		System.out.print("Passport Number: ");
		String passport_num = str_scanner.nextLine();
		
		Passenger p1 = new Passenger(name, gender, age, address, phone_num, passport_num);
		return p1;
	}
	
	private String select_flight_class()
	{
		System.out.println("1:\tBusiness");
		System.out.println("2:\tFirst");
		System.out.println("3:\tEconomy");
		
		Scanner int_scanner = new Scanner(System.in);
		int option = int_scanner.nextInt();
		switch (option) {
			case 1: return "business";
			case 2: return "first";
			case 3: return "economy";
			default: break;
		}
		return "invalid";
	}
	
	
}
