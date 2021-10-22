package flight_reservation;

public class Plane {
	int businessClassSeats;
	int firstClassSeats;
	int economyClassSeats;
	
	public Plane(int bClassSeats, int fClassSeats, int eClassSeats)
	{
		this.businessClassSeats = bClassSeats;
		this.firstClassSeats = fClassSeats;
		this.economyClassSeats = eClassSeats;
	}

}
