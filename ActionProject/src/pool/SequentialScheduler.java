package pool;

public class SequentialScheduler extends Scheduler {

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
