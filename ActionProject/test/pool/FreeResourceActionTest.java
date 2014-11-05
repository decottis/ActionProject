package pool;

import static org.junit.Assert.*;
import org.junit.Test;

public class FreeResourceActionTest extends ActionTest {
	protected ResourcePool<Cubicle> cubiclePool;
	protected ResourcefulUser<Cubicle> user;
	protected Action freeResource;
	protected Cubicle cubicle;
	
	@Test
	public void freeResourcesTest() {
		cubiclePool = new CubiclePool(1);
		user = new ResourcefulUser<Cubicle>();
		assertTrue(user.getResource() == null);
		user.setResource(cubiclePool.provideResource());
		freeResource = new FreeResourceAction<Cubicle>(user,cubiclePool);
		freeResource.doStep();
		assertFalse(cubiclePool.available.isEmpty());
		assertTrue(user.getResource() == null);
	}
	@Override
	public Action createAction() {
		cubiclePool = new CubiclePool(10);
		user = new ResourcefulUser<Cubicle>();
		Action takeResource = new TakeResourceAction<Cubicle>(user,cubiclePool);
		takeResource.doStep();
		return new FreeResourceAction<Cubicle>(user,cubiclePool); 
	}
}
