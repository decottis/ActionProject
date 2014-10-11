package pool;


public class SequentialScheduler extends Scheduler {
	
	public void doStep() throws ActionFinishedExeption{
		if(this.state == State.FINISHED) {
			throw new ActionFinishedExeption();
		}
		getFirstActionNotFinished().doStep();
		this.stepCounter++;
		if(this.isFinished()){
			this.state = State.FINISHED;
		} /*else if(++this.stepCounter == this.nbSteps){
			this.state = State.FINISHED;
		} */else {
			this.state = State.INPROGRESS;
		}
	}
	
	public Action getFirstActionNotFinished(){
		Action tmp;
		for(int i = 0; i < this.actions.size(); i++){
			tmp = this.actions.get(i);
			if(!tmp.isFinished()) return tmp;
		}
		return null;
		
	}
}
