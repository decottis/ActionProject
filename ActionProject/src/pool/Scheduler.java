package pool;

import java.util.ArrayList;

public abstract class Scheduler extends Action {

	protected ArrayList<Action> actions;
	
	public Scheduler() {
		
	}
	
	@Override
	public void reallyDotStep() {
		
	}
	
	public boolean isFinished(){
		for(Action e : actions){
			if(!e.isFinished()) return false;
		}
		return true;
	}
	
	public void addAction(Action action){
		this.actions.add(action);
	}

}
