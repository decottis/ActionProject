package pool;

import java.util.ArrayList;
import java.util.NoSuchElementException;
/**
 * Represents a Resource set
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 * @param <R>
 */
public abstract class ResourcePool<R extends Resource> {

	protected String description;
	protected ArrayList<R> available;
	protected ArrayList<R> unavailable;

	public ResourcePool(String description, int size) {
		this.description = description;
		this.available = new ArrayList<R>(size);
		for (int i = 0; i < size; i++) {
			this.available.add(createResource());
		}
		this.unavailable = new ArrayList<R>(size);
	}
	/**
	 * Function implements in children classes of ResourcePool who returns a specific Resource
	 * @return
	 */
	public abstract R createResource();

	/**
	 * Function who return a Resource if that one is available
	 * @return
	 * @throws NoSuchElementException
	 */
	public R provideResource() throws NoSuchElementException {
		if (this.available.isEmpty())
			throw new NoSuchElementException();
		else {
			R tmp = this.available.get(0);
			this.unavailable.add(tmp);
			this.available.remove(0);
			return tmp;
		}
	}

	/**
	 * Method who free a Resource if that one is available
	 * @param r
	 * @throws IllegalArgumentException
	 */
	public void freeResource(R r) throws IllegalArgumentException {
		if (this.unavailable.contains(r)) {
			this.unavailable.remove(r);
			this.available.add(r);
		} else {
			throw new IllegalArgumentException();
		}

	}
	
	/**
	 * Return the Resource Pool description
	 */
	public String getDescription(){
		return this.description;
	}

}
