package flight_reservation;

public class Invoice {
	int bill;
	Booking booking;
	Boolean status;
	
	public Invoice(Booking b) {
		this.bill = -1;
		this.booking = b;
		this.status = false;
	}
	
	public void calculateBill()
	{
		this.bill = 0;
		Ticket t1 = null;
		Flight f1 = booking.flight;
		for(int i = 0; i < booking.tickets.size(); i++)
		{
			t1 = booking.tickets.get(i);
			int price = f1.price.get(t1.classType);
			this.bill += price;
		}
	}
	
	public void printInvoice()
	{
		System.out.println("Booking ID: " + booking.id);
		System.out.println("Total Bill: " + String.valueOf(this.bill));
		if(this.status)
			System.out.println("Status: Paid");
		else
			System.out.println("Status: Not Paid");
	}

}
