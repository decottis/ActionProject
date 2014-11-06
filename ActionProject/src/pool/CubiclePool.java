package pool;

/**
 * Represents a Cubicle set
 * 
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public class CubiclePool extends ResourcePool<Cubicle> {

	public CubiclePool(int size) {
		super("CubiclePool", size);
	}

	/**
	 * Create a new Cubicle resource
	 */
	@Override
	public Cubicle createResource() {
		return new Cubicle();
	}

}
