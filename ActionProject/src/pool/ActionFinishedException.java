package pool;

/**
 * Represents an exception who can be throw if we execute an action doStep
 * already finished
 * 
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public class ActionFinishedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ActionFinishedException() {
		super("Action finished.");
	}

}
