package flight_reservation;

import java.util.Vector;

public class Customer {
	String login;
	String password;
	Vector<Invoice> invoices;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String login, String passowrd) {
		this.login = login;
		this.password = passowrd;
	}
	
	void validate_password(String pass) throws PasswordMismatchException
	{
		if(pass != this.password)
			throw new PasswordMismatchException("Password do not match!");
	}
}
