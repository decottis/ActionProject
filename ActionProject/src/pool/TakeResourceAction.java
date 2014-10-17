package pool;

import java.util.NoSuchElementException;

public class TakeResourceAction<R extends Resource> extends Action {

	protected ResourcePool rp;
	protected ResourcefulUser<Resource> ru;
	
	public TakeResourceAction(ResourcefulUser<Resource> ru, ResourcePool rp) {
		this.rp=rp;
		this.ru = ru;
		this.state = State.READY;
	}
	
	public void doStep() throws NoSuchElementException, ActionFinishedException{
			super.doStep();
			try{
				ru.setResource(rp.provideResource());
			} catch (NoSuchElementException e){
				this.state = State.INPROGRESS;
			}
			this.state = State.FINISHED;
			
	}
}
