package pool;
/**
 * It's a Scheduler who used a fair distribution of the action's progress
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public class SequentialScheduler extends Scheduler {

	public SequentialScheduler() {
		super();
	}
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
