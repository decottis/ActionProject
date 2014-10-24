package pool;

public class FairScheduler extends Scheduler {

	int index;
	public FairScheduler(){
		index = 0;
	}
	
	public void doStep() throws ActionFinishedException{
		if(this.state == State.FINISHED) {
			throw new ActionFinishedException();
		}
		getAfterActionNotFinished().doStep();
		this.stepCounter++;
		if(this.isFinished()){
			this.state = State.FINISHED;
		} /*else if(++this.stepCounter == this.nbSteps){
			this.state = State.FINISHED;
		} */else {
			this.state = State.INPROGRESS;
		}
	}
	
	public Action getAfterActionNotFinished(){
		for(int i = this.index+1; i < this.actions.size(); i++){
			Action tmp = this.actions.get(i);
			if(!tmp.isFinished()) {
				this.index = i;
				return tmp;
			}
		}
		return null;
		
	}
}
