package pool;
public abstract class Action {
	/**
	 * Number of steps for finish this action.
	 */
	protected int nbSteps;
	/**
	 * The current step number.
	 */
	protected int stepCounter;
	/**
	 * The state of this action : READY, INPROGRESS, FINISHED.
	 */
	protected State state;
	public enum State{
		READY,
		INPROGRESS,
		FINISHED;
	}
	/**
	 * Build action with state attribute on ready.
	 */
	public Action(){
		this.state = State.READY;
		
	}
	/**
	 * Make one step of this action.
	 * @throws ActionFinishedExeption
	 */
	public void doStep() throws ActionFinishedExeption{
		if(this.state == State.FINISHED) {
			throw new ActionFinishedExeption();
		} else if(++this.stepCounter == this.nbSteps){
			this.state = State.FINISHED;
		} else {
			this.state = State.INPROGRESS;
		}
	}
	/**
	 * 
	 */
	public abstract void reallyDotStep();
	/**
	 * 
	 * @return true if state is finished, false else.
	 */
	public boolean isFinished(){
		return this.state == State.FINISHED;
		
	}
	
}
