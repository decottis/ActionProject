package pool;
/**
 * It's a Scheduler who used a sequential distribution of the action's progress
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public class SequentialScheduler extends Scheduler {

	public SequentialScheduler() {
		super();
	}
	/**
	 * Method who does the action : execute action with a sequential distribution of the action's progress
	 */
	public void doStep() throws ActionFinishedException {
		if (this.state == State.FINISHED) {
			throw new ActionFinishedException();
		}
		this.getFirstActionNotFinished().doStep();
		this.stepCounter++;
		if (this.allActionsAreFinished()) {
			this.state = State.FINISHED;
		} else {
			this.state = State.INPROGRESS;
		}
	}

	/**
	 * Method used in doStep function of SequentialScheduler class who return the first action not finished of his action list
	 * @return
	 */
	public Action getFirstActionNotFinished() {
		Action tmp;
		for (int i = 0; i < this.actions.size(); i++) {
			tmp = this.actions.get(i);
			if (!tmp.isFinished())
				return tmp;
		}
		return null;

	}
}
