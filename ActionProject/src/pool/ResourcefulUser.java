package pool;
/**
 * Represents a space who contain a specific single resource
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 * @param <R>
 */
public class ResourcefulUser<R extends Resource> {
	protected R resource;

	/**
	 * Function who returns the specific stocked resource
	 * @return
	 */
	public R getResource() {
		return this.resource;
	}

	/**
	 * Method who set a specific resource in this space
	 * @param resource
	 */
	public void setResource(R resource) {
		this.resource = resource;
	}

	/**
	 * Method who destroys the specific stocked resource in this space if that one is available
	 */
	public void resetResource() {
		this.resource = null;
	}
}
