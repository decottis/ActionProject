package pool;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;
import org.junit.Test;

public class TakeResourceActionTest extends ActionTest {

	protected ResourcePool<Basket> basketPool;
	protected ResourcefulUser<Basket> user;
	protected Action takeResource;
	
	@Test(expected=NoSuchElementException.class)
	public void takeResourcesInEmptyPoolTest() {
		basketPool = new BasketPool(0);
		user = new ResourcefulUser<Basket>();
		takeResource = new TakeResourceAction<Basket>(user,basketPool);
		// In logic throw NoSuchElementException 
		takeResource.doStep();
	}
	@Test
	public void takeResourcesTest() {
		basketPool = new BasketPool(1);
		user = new ResourcefulUser<Basket>();
		assertTrue(user.getResource() == null);
		takeResource = new TakeResourceAction<Basket>(user,basketPool);
		takeResource.doStep();
		assertFalse(basketPool.unavailable.isEmpty());
		assertTrue(user.getResource() != null);
	}
	@Override
	public Action createAction() {
		return new TakeResourceAction<Basket>(new ResourcefulUser<Basket>(),new BasketPool(10)); 
	}
}

