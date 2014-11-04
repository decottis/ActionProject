package pool;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class ResourcePool<R extends Resource> {
	protected ArrayList<R> available;
	protected ArrayList<R> unavailable;

	public ResourcePool(int size) {
		this.available = new ArrayList<R>(size);
		for (int i = 0; i < size; i++) {
			this.available.add(this.createResource());
		}
		this.unavailable = new ArrayList<R>(size);
	}

	public abstract R createResource();

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

	public void freeResource(R r) throws IllegalArgumentException {
		if (this.unavailable.contains(r)) {
			this.unavailable.remove(r);
			this.available.add(r);
		} else {
			throw new IllegalArgumentException();
		}

	}

}
