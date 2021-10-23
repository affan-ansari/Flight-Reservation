package flight_reservation;

public class Ticket {
	String seatNo;
	Passenger passenger;
	String classType;
	
	public Ticket() {
		// TODO Auto-generated constructor stub
	}
	
	public Ticket(String s, Passenger p, String c)
	{
		this.seatNo = s;
		this.passenger = p;
		this.classType = c;
	}
	
	public void printTicket()
	{
		System.out.println("Class:\t\t" + this.classType);
		System.out.println("Seat No:\t" + this.seatNo);
		System.out.println("Name: " + this.passenger.name);
		System.out.print("Gender: " + this.passenger.gender);
		System.out.print("\tAge: " + this.passenger.age);
		System.out.println("\tPassport: " + this.passenger.passportNumber);
		System.out.println();
	}

}
