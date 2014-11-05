package pool;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public abstract class ResourcePoolTest {

	ResourcePool<Resource> pool;
	public abstract ResourcePool<?> createResourcePool();
	
	@Test(expected=NoSuchElementException.class)
	public void provideResourceInEmptyPoolTest() {
		pool = ((ResourcePool<Resource>) createResourcePool());
		// In logic throw NoSuchElementException 
		pool.provideResource();
	}
	@Test(expected=IllegalArgumentException.class)
	public void freeResourceNotInPool() {
		pool = (ResourcePool<Resource>) createResourcePool();
		// In logic throw IllegalArgumentException 
		pool.freeResource(new Basket());
	}
}
