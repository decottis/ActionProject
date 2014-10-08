package pool;
public abstract class Action {
	protected int nbSteps;
	protected int stepCounter;
	protected State state;
	
	public enum State{
		READY,
		INPROGRESS,
		FINISHED;
	}
	public Action(){
		this.state = State.READY;
		
	}
	
	public void doStep() throws ActionFinishedExeption{
		if(this.state == State.FINISHED) {
			throw new ActionFinishedExeption();
		} else if(++this.stepCounter == this.nbSteps){
			this.state = State.FINISHED;
		} else {
			this.state = State.INPROGRESS;
		}
	}
	
	public abstract void reallyDotStep();
	
	public boolean isFinished(){
		return this.state == State.FINISHED;
		
	}
	
}
