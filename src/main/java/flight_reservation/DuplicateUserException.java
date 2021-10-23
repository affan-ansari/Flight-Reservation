package flight_reservation;

@SuppressWarnings("serial")
public class DuplicateUserException extends Exception{
	public DuplicateUserException(String message)
	{
		super(message);
	}
}
