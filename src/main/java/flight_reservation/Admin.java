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
