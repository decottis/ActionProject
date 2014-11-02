package pool;

public class FairScheduler extends Scheduler {

	protected int index;

	public FairScheduler() {
		this.index = 0;
	}

	public void doStep() throws ActionFinishedException {
		super.doStep();

		Action tmp = getAfterActionNotFinished();

		if (tmp != null) {
			tmp.doStep();
			this.state = State.INPROGRESS;
		} else {
			this.state = State.FINISHED;
		}

		if (this.allActionsAreFinished())
			this.state = State.FINISHED;
	}

	public Action getAfterActionNotFinished() {
		if (this.index == this.actions.size())
			this.index = 0;
		/* On regarde après l'index */
		for (int i = this.index; i < this.actions.size(); i++) {
			if (!this.actions.get(i).isFinished()) {
				this.index = i + 1;
				return this.actions.get(i);
			}
		}
		/*
		 * Si l'on a pas retourné une action, on regarde avant l'index en
		 * partant du début de la liste d'actions
		 */
		for (int i = 0; i < this.index; i++) {
			if (!this.actions.get(i).isFinished()) {
				this.index = i + 1;
				return this.actions.get(i);
			}
		}
		return null;
	}
}
