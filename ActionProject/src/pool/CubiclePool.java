package pool;

public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int size) {
		super(size);
	}

	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}

}
