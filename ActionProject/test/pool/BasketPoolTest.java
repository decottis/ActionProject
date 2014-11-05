package pool;

public class BasketPoolTest extends ResourcePoolTest {


	@Override
	public ResourcePool<?> createResourcePool() {
		ResourcePool<Basket> pool = new BasketPool(0) ;
		return pool;
	}

}
