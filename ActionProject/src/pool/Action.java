package pool;
/**
 * 
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public abstract class Action {
	/**
	 * Number of steps for finish this action.
	 */
	protected int nbStepsMax;
	/**
	 * The current step number.
	 */
	protected int stepCounter;
	/**
	 * The state of this action : READY, INPROGRESS, FINISHED.
	 */
	protected State state;

	public enum State {
		READY, INPROGRESS, FINISHED;
	}

	/**
	 * Build action with state attribute on ready.
	 */
	public Action() {
		this.state = State.READY;
	}

	/**
	 * Make one step of this action.
	 * 
	 * @throws ActionFinishedException
	 */
	public void doStep() throws ActionFinishedException {
		if (this.state == State.FINISHED)
			throw new ActionFinishedException();
	}

	/**
	 * 
	 */
	public boolean isFinished() {
		return this.state == State.FINISHED;
	}

}
