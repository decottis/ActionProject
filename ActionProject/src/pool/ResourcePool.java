package pool;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class ResourcePool<R extends Resource>{
	protected ArrayList<R> available;
	protected ArrayList<R> unavailable;
	
	public ResourcePool(int size){
		available = new ArrayList<R>(size);
		for(int i = 0; i < size; i ++){
			available.add(createResource());
		}
		unavailable = new ArrayList<R>(size);
	}
	
	public abstract R createResource();
	
	public R provideResource() throws NoSuchElementException{
		if(available.isEmpty()) throw new NoSuchElementException();
		unavailable.add(available.get(0));
		return available.get(0);
	}
	
	public void freeResource(R r) throws IllegalArgumentException{
		if(unavailable.contains(r)){
			unavailable.remove(r);
			available.add(r);
		} else {
			throw new IllegalArgumentException();
		}
				
		
	}

}
