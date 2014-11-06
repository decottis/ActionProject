package pool;

import java.util.NoSuchElementException;

import org.junit.Test;

public abstract class ResourcePoolTest<R extends Resource> {

	ResourcePool<R> pool;
	public abstract ResourcePool<R> createResourcePool();
	public abstract R createResource();
	
	@Test(expected=NoSuchElementException.class)
	public void provideResourceInEmptyPoolTest() {
		pool = createResourcePool();
		// In logic throw NoSuchElementException 
		pool.provideResource();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void freeResourceNotInPool() {
		pool = createResourcePool();
		// In logic throw IllegalArgumentException 
		pool.freeResource(createResource());
	}
}
