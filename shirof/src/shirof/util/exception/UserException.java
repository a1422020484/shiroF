package shirof.util.exception;

public class UserException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserException(){
		
	}
	public UserException(String string) {
		// TODO Auto-generated constructor stub
		System.err.println(string);
	}
}
