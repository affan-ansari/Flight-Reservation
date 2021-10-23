package flight_reservation;

public class Passenger {
	String name;
	String gender;
	int age;
	String address;
	String phoneNumber;
	String passportNumber;
	
	public Passenger() {
		// TODO Auto-generated constructor stub
	}
	public Passenger(String name, String gender, int age, String address, String phoneNumber, String passportNumber)
	{
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.passportNumber = passportNumber;
	}

}
