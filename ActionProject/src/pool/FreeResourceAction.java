package pool;

public class FreeResourceAction<R extends Resource> extends Action {
	protected ResourcePool<R> rp;
	protected ResourcefulUser<R> ru;
	
	public FreeResourceAction(ResourcefulUser<R> ru, ResourcePool<R> rp) {
		this.rp=rp;
		this.ru = ru;
		this.state = State.READY;
	}
	
	public void doStep() throws IllegalArgumentException, ActionFinishedException{
			super.doStep();
			try{
				rp.freeResource(ru.getResource());
			} catch (IllegalArgumentException e){
				this.state = State.INPROGRESS;
			}
			this.state = State.FINISHED;
			
	}
}
