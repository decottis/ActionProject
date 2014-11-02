package pool;

import java.util.NoSuchElementException;

public class TakeResourceAction<R extends Resource> extends Action {

	protected ResourcePool<R> rp;
	protected ResourcefulUser<R> ru;
	
	public TakeResourceAction(ResourcefulUser<R> ru, ResourcePool<R> rp) {
		this.rp=rp;
		this.ru = ru;
		this.state = State.READY;
	}
	
	public void doStep() throws NoSuchElementException, ActionFinishedException{
			super.doStep();
			String display = "\tTrying to take ressource from pool " /*+ ru.getResource().getDescription()*/ + "... ";
			try{
				this.ru.setResource(this.rp.provideResource());
				
				display += this.ru.getResource().getDescription();
				display += " success ";
				display += "elements restant : " + this.rp.available.size();
				this.state = State.FINISHED;
			} catch (NoSuchElementException e){
				this.state = State.INPROGRESS;
				display += " failed ";
			} finally {
				System.out.println(display);
			}
	}
}
