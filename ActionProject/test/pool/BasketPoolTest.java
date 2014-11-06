package pool;

public class BasketPoolTest extends ResourcePoolTest<Basket> {


	@Override
	public ResourcePool<Basket> createResourcePool() {
		ResourcePool<Basket> pool = new BasketPool(0) ;
		return pool;
	}

	@Override
	public Basket createResource() {
		return new Basket();
	}

}
