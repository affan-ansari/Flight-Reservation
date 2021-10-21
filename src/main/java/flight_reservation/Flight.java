package flight_reservation;

import java.util.*;
import java.time.*;

public class Flight {
	String source;
	String destination;	
	LocalDateTime departureDateTime;
	LocalDateTime arrivalDateTime;
	
	@SuppressWarnings("rawtypes")
	Dictionary price = new Hashtable();
	Plane plane;
	
	public Flight() {
		// TODO Auto-generated constructor stub
	}

}
