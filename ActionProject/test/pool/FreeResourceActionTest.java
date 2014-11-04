package pool;

import static org.junit.Assert.*;
import org.junit.Test;

public class FreeResourceActionTest extends ActionTest {
	protected ResourcePool<Basket> basketPool;
	protected ResourcefulUser<Basket> user;
	protected Action freeResource;
	protected Basket basket;
	
	@Test(expected=IllegalArgumentException.class)
	public void freeResourcesFromAnotherPoolTest() {
		basketPool = new BasketPool(4);
		basket = new Basket();
		user = new ResourcefulUser<Basket>();
		// put another resource in user
		user.setResource(basket);
		// try to free it.
		freeResource = new FreeResourceAction<Basket>(user,basketPool);
		freeResource.doStep();
		// In logic throw IllegalArgumentException 
		freeResource.doStep();
	}
	@Test
	public void freeResourcesTest() {
		basketPool = new BasketPool(1);
		user = new ResourcefulUser<Basket>();
		assertTrue(user.getResource() == null);
		user.setResource(basketPool.provideResource());
		freeResource = new FreeResourceAction<Basket>(user,basketPool);
		freeResource.doStep();
		assertFalse(basketPool.available.isEmpty());
		assertTrue(user.getResource() == null);
	}
	@Override
	public Action createAction() {
		basketPool = new BasketPool(10);
		user = new ResourcefulUser<Basket>();
		Action takeResource = new TakeResourceAction<Basket>(user,basketPool);
		takeResource.doStep();
		return new FreeResourceAction<Basket>(user,basketPool); 
	}
}
