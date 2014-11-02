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
			
			String display = "\tTrying to free ressource to pool " + this.ru.getResource().getDescription() + "... ";
			try{
				this.rp.freeResource(this.ru.getResource());
				this.ru.resetResource();
				display += " success ";
			} catch (IllegalArgumentException e){
				this.state = State.INPROGRESS;
				display += " failed ";
			} finally {
				System.out.println(display);
			}
			this.state = State.FINISHED;
			
	}
}
