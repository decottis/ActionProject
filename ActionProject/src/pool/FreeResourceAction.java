package pool;

/**
 * Represents the action to return a resource from ResourcefulUser to a
 * ResourcePool
 * 
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 * @param <R>
 */
public class FreeResourceAction<R extends Resource> extends Action {
	protected ResourcePool<R> rp;
	protected ResourcefulUser<R> ru;

	public FreeResourceAction(ResourcefulUser<R> ru, ResourcePool<R> rp) {
		this.rp = rp;
		this.ru = ru;
		this.state = State.READY;
	}

	/**
	 * Method who does the action : return a resource from ResourcefulUser to a
	 * ResourcePool
	 */
	public void doStep() throws IllegalArgumentException,
			ActionFinishedException {
		super.doStep();

		String display = "\tTrying to free resource to "
				+ this.rp.getDescription() + "... ";
		try {
			this.rp.freeResource(this.ru.getResource());
			this.ru.resetResource();
			display += " success ";
			display += "\n \t\t Available Resource Number in "
					+ this.rp.getDescription() + " : "
					+ this.rp.available.size();
		} catch (IllegalArgumentException e) {
			this.state = State.INPROGRESS;
			display += " failed ";
		} finally {
			System.out.println(display);
		}
		this.state = State.FINISHED;

	}
}
