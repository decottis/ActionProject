package pool;

public class ActionFinishedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ActionFinishedException() {
		super("Action finished.");
	}
	
	public ActionFinishedException(String message) {
		super(message);
	}
	
}
