package flight_reservation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class Admin {
	Vector<Customer> customers;
	Vector<Flight> flights;
	
	public Admin() 
	{
		this.customers = new Vector<Customer>();
		this.flights = new Vector<Flight>();
	}
	
	public Customer login_customer(String login, String password) throws PasswordMismatchException, UserDoesNotExistException
	{
		Customer c1 = null;
		for(int i = 0; i < this.customers.size(); i++)
		{
			if (this.customers.get(i).login.equals(login))
			{
				c1 = this.customers.get(i);
				break;
			}
		}
		if (c1 == null)
			throw new UserDoesNotExistException("User does not exist");
		c1.validate_password(password);
		return c1;
	}
	
	public void add_flight() throws IOException
	{
		Scanner sc = new Scanner(System.in);
		FileWriter pw = new FileWriter("flights.csv", true);
		
		System.out.print("Source: ");
		String source = sc.nextLine();
		pw.append(source);
		pw.append(",");
		System.out.print("Destination: ");
		String destination = sc.nextLine();
		pw.append(destination);
		pw.append(",");
		System.out.print("Departure Year: ");
		String dYear = sc.nextLine();
		pw.append(dYear);
		pw.append(",");
		System.out.print("Departure Month: ");
		String dMonth = sc.nextLine();
		pw.append(dMonth);
		pw.append(",");
		System.out.print("Departure Day: ");
		String dDay = sc.nextLine();
		pw.append(dDay);
		pw.append(",");
		System.out.print("Departure Hour: ");
		String dHour = sc.nextLine();
		pw.append(dHour);
		pw.append(",");
		System.out.print("Departure Miniute: ");
		String dMin = sc.nextLine();
		pw.append(dMin);
		pw.append(",");
		
		System.out.print("Arrival Year: ");
		String aYear = sc.nextLine();
		pw.append(aYear);
		pw.append(",");
		System.out.print("Arrival Month: ");
		String aMonth = sc.nextLine();
		pw.append(aMonth);
		pw.append(",");
		System.out.print("Arrival Day: ");
		String aDay = sc.nextLine();
		pw.append(aDay);
		pw.append(",");
		System.out.print("Arrival Hour: ");
		String aHour = sc.nextLine();
		pw.append(aHour);
		pw.append(",");
		System.out.print("Arrival Miniute: ");
		String aMin = sc.nextLine();
		pw.append(aMin);
		pw.append(",");
		
		System.out.print("Business Price: ");
		String bPrice = sc.nextLine();
		pw.append(bPrice);
		pw.append(",");
		System.out.print("First Price: ");
		String fPrice = sc.nextLine();
		pw.append(fPrice);
		pw.append(",");
		System.out.print("Economy Price: ");
		String ePrice = sc.nextLine();
		pw.append(ePrice);
		pw.append(",");
		
		System.out.print("Business Seats: ");
		String bSeats = sc.nextLine();
		pw.append(bSeats);
		pw.append(",");
		System.out.print("First Seats: ");
		String fSeats = sc.nextLine();
		pw.append(fSeats);
		pw.append(",");
		System.out.print("Economy Seats: ");
		String eSeats = sc.nextLine();
		pw.append(eSeats);
		pw.append("\n");
		
		pw.close();
	}
	
	@SuppressWarnings("resource")
	public void register_customer() throws PasswordMismatchException, DuplicateUserException, IOException
	{
		Scanner str_scanner = new Scanner(System.in);
		Customer c1 = new Customer();
		
		System.out.println("Enter username");
		String login = str_scanner.nextLine();
		
		for(int i = 0; i < this.customers.size(); i++)
		{
			if(login.equals(customers.get(i).login))
				throw new DuplicateUserException("User already exists!");
		}
		
		c1.login = login;
		System.out.println("Enter password");
		c1.password = str_scanner.nextLine();
		System.out.println("Confirm password");
		String pass2 = str_scanner.nextLine();
		
		if(c1.password.equals(pass2) == false)
		{
			throw new PasswordMismatchException("Password do not match!");
		}
		
		FileWriter pw = new FileWriter("customers.csv",true);
		pw.append(c1.login);
		pw.append(",");
		pw.append(c1.password);
		pw.append("\n");
		
		pw.close();
		this.customers.add(c1);
	}

}
