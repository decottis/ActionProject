package pool;
/**
 * It's a Scheduler who used a fair distribution of the action's progress
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public class FairScheduler extends Scheduler {

	protected int index;

	public FairScheduler() {
		this.index = 0;
	}

	/**
	 * Method who does the action : execute action with a fair distribution of the action's progress
	 */
	public void doStep() throws ActionFinishedException {
		super.doStep();
		
		getAfterActionNotFinished().doStep();
		
		if (allActionsAreFinished()){
			this.state = State.FINISHED;
		} else {
			this.state = State.INPROGRESS;
		}
	}

	/**
	 * Method used in doStep function of FairScheduler class who returns the first action not finished of his action list next the last action executed
	 * @return
	 */
	public Action getAfterActionNotFinished() {
		if (this.index == this.actions.size())
			this.index = 0;
		/* We search after position of the last used action */
		for (int i = this.index; i < this.actions.size(); i++) {
			if (!this.actions.get(i).isFinished()) {
				this.index = i + 1;
				return this.actions.get(i);
			}
		}
		/*If the search doesn't succeed, we look before the index begin at the list action start*/
		for (int i = 0; i < this.index; i++) {
			if (!this.actions.get(i).isFinished()) {
				this.index = i + 1;
				return this.actions.get(i);
			}
		}
		return null;
	}
}
