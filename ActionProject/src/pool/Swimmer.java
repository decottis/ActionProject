package pool;
/**
 * 
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public class Swimmer extends SequentialScheduler {
	protected String name;
	protected BasketPool bp;
	protected CubiclePool cp;
	ResourcefulUser<Basket> basket = new ResourcefulUser<Basket>();
	ResourcefulUser<Cubicle> cubicle = new ResourcefulUser<Cubicle>();
	protected int timeUndress, timeSwam, timeToDress;

	public Swimmer(String name, BasketPool basketPool, CubiclePool cubiclePool,
			int timeToUndress, int timeToSwim, int timeToDress) {
		this.name = name;
		this.bp = basketPool;
		this.cp = cubiclePool;
		this.timeUndress = timeToUndress;
		this.timeSwam = timeToSwim;
		this.timeToDress = timeToDress;

		this.basket = new ResourcefulUser<Basket>();
		this.cubicle = new ResourcefulUser<Cubicle>();

		this.state = State.READY;

		this.initActions();
	}

	private void initActions() {
		this.addAction(new TakeResourceAction<Basket>(this.basket, this.bp));
		this.addAction(new TakeResourceAction<Cubicle>(this.cubicle, this.cp));
		this.addAction(new ForeeasableAction("undressing", this.timeUndress));
		this.addAction(new FreeResourceAction<Cubicle>(this.cubicle, this.cp));
		this.addAction(new ForeeasableAction("swimming", this.timeSwam));
		this.addAction(new TakeResourceAction<Cubicle>(this.cubicle, this.cp));
		this.addAction(new ForeeasableAction("dressing", this.timeToDress));
		this.addAction(new FreeResourceAction<Cubicle>(this.cubicle, this.cp));
		this.addAction(new FreeResourceAction<Basket>(this.basket, this.bp));
	}

	public void doStep() {
		System.out.println(this.name + " play turn : ");
		super.doStep();
	}
}
