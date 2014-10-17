package pool;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public abstract class ResourcePool implements Resource{
	protected ArrayList<Resource> available;
	protected ArrayList<Resource> unavailable;
	
	public ResourcePool(int size){
		available = new ArrayList<Resource>(size);
		for(int i = 0; i < size; i ++){
			available.add(createResource());
		}
		unavailable = new ArrayList<Resource>(size);
	}
	
	public abstract Resource createResource();
	
	public Resource provideResource() throws NoSuchElementException{
		if(available.isEmpty()) throw new NoSuchElementException();
		unavailable.add(available.get(0));
		return available.get(0);
	}
	
	public void freeResource(Resource r) throws IllegalArgumentException{
		if(unavailable.contains(r)){
			unavailable.remove(r);
			available.add(r);
		} else {
			throw new IllegalArgumentException();
		}
				
		
	}

}
