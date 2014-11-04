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

	@Override
	public Basket createResource() {
		return new Basket();
	}

}
