package pool;

public class CubiclePoolTest extends ResourcePoolTest<Cubicle> {

	@Override
	public ResourcePool<Cubicle> createResourcePool() {
		ResourcePool<Cubicle> pool = new CubiclePool(0);
		return pool;
	}

	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}


}
