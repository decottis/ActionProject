package pool;

public class BasketPool extends ResourcePool {

	public BasketPool(int size) {
		super(size);
	}

	@Override
	public Resource createResource() {
		return new Basket();
	}

}
