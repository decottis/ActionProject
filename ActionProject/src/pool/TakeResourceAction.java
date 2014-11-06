package pool;

import java.util.NoSuchElementException;

/**
 * Represents the action to take a resource from a ResourcePool and record this
 * in a ResourcefulUser
 * 
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 * @param <R>
 */
public class TakeResourceAction<R extends Resource> extends Action {

	protected ResourcePool<R> rp;
	protected ResourcefulUser<R> ru;

	public TakeResourceAction(ResourcefulUser<R> ru, ResourcePool<R> rp) {
		this.rp = rp;
		this.ru = ru;
		this.state = State.READY;
	}

	/**
	 * Method who does the action : take a resource from a ResourcePool and
	 * record this in a ResourcefulUser
	 */
	public void doStep() throws NoSuchElementException, ActionFinishedException {
		super.doStep();
		String display = "\tTrying to take resource from "
				+ this.rp.getDescription() + " ... ";
		try {
			this.ru.setResource(this.rp.provideResource());
			display += " success ";
			display += "\n \t\t Available Resource Number in "
					+ this.rp.getDescription() + " : "
					+ this.rp.available.size();
			this.state = State.FINISHED;
		} catch (NoSuchElementException e) {
			this.state = State.INPROGRESS;
			display += " failed ";
		} finally {
			System.out.println(display);
		}
	}
}
