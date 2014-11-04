package pool;
/**
 * Represents a Basket set
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public class BasketPool extends ResourcePool<Basket> {

	public BasketPool(int size) {
		super(size);
	}

	/**
	 * Create a new Basket resource
	 */
	@Override
	public Basket createResource() {
		return new Basket();
	}

}
