
public class InvalidNicknameException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidNicknameException(String message) {
		super("Invalid nickname");
	}
}
