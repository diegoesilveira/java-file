package exception;

public class ErrorFileException extends Exception {

	private static final long serialVersionUID = 1L;

	public ErrorFileException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ErrorFileException(String message) {
		super(message);
	}

	
}
