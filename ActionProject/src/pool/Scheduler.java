package pool;

import java.util.ArrayList;

/**
 * Represents an action built of an action set
 * 
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public abstract class Scheduler extends Action {

	protected ArrayList<Action> actions;

	public Scheduler() {
		this.actions = new ArrayList<Action>();
	}

	/**
	 * Function who return true if all actions are finished
	 * 
	 * @return
	 */
	public boolean allActionsAreFinished() {
		for (Action e : this.actions) {
			if (!e.isFinished())
				return false;
		}
		return true;
	}

	/**
	 * Method who add an action in the action set
	 * 
	 * @param action
	 */
	public void addAction(Action action) {
		this.actions.add(action);
	}

}
