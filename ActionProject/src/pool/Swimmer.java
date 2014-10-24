package pool;

public class Swimmer extends FairScheduler{
	protected String name;
	protected BasketPool bp;
	protected CubiclePool cp;
	protected int timeUndress, timeSwam, timeToDress;
	
	
	public Swimmer(String name, BasketPool basketPool, CubiclePool cubiclePool, int timeToUndress, int timeToSwim, int timeToDress){
		this.name = name;
		this.bp = basketPool;
		this.cp = cubiclePool;
		this.timeUndress = timeToUndress;
		this.timeSwam = timeToSwim;
		this.timeToDress = timeToDress;
		
		this.state = State.READY;
		
		initActions();
	}
	
	private void initActions(){
		ResourcefulUser<Basket> basket = new ResourcefulUser<Basket>();
		ResourcefulUser<Cubicle> cubicle = new ResourcefulUser<Cubicle>();
		this.addAction(new TakeResourceAction<Basket>(basket, bp));
		this.addAction(new TakeResourceAction<Cubicle>(cubicle, cp));
		this.addAction(new ForeeasableAction(timeUndress));
		this.addAction(new FreeResourceAction<Cubicle>(cubicle, cp));
		this.addAction(new ForeeasableAction(timeSwam));
		this.addAction(new TakeResourceAction<Cubicle>(cubicle, cp));
		this.addAction(new ForeeasableAction(timeToDress));
		this.addAction(new FreeResourceAction<Cubicle>(cubicle, cp));
		this.addAction(new FreeResourceAction<Basket>(basket, bp));
	}
	
	public void doStep(){
		System.out.println(this.name + " play turn : ");
		super.doStep();
		
	}
}
