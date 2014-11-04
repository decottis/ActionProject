package pool;

import java.util.ArrayList;
/**
 * 
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public abstract class Scheduler extends Action {

	protected ArrayList<Action> actions;

	public Scheduler() {
		this.actions = new ArrayList<Action>();
	}

	public boolean allActionsAreFinished() {
		for (Action e : this.actions) {
			if (!e.isFinished())
				return false;
		}
		return true;
	}

	public void addAction(Action action) {
		this.actions.add(action);
	}

}
