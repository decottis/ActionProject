package pool;

import java.util.NoSuchElementException;

import org.junit.Test;

public abstract class ResourcePoolTest {

	ResourcePool<Resource> pool;
	public abstract ResourcePool<?> createResourcePool();
	
	@SuppressWarnings("unchecked")
	@Test(expected=NoSuchElementException.class)
	public void provideResourceInEmptyPoolTest() {
		pool = ((ResourcePool<Resource>) createResourcePool());
		// In logic throw NoSuchElementException 
		pool.provideResource();
	}
	@SuppressWarnings("unchecked")
	@Test(expected=IllegalArgumentException.class)
	public void freeResourceNotInPool() {
		pool = (ResourcePool<Resource>) createResourcePool();
		// In logic throw IllegalArgumentException 
		pool.freeResource(new Basket());
	}
}
