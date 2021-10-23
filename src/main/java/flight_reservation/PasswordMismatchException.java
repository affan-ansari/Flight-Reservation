package flight_reservation;

@SuppressWarnings("serial")
public class PasswordMismatchException extends Exception{
	public PasswordMismatchException(String message)
	{
		super(message);
	}
}
