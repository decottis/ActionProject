package pool;
/**
 * Represents a swimmer in a Pool (action set)
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public class Swimmer extends SequentialScheduler {
	protected String name;
	protected BasketPool bp;
	protected CubiclePool cp;
	protected ResourcefulUser<Basket> basket;
	protected ResourcefulUser<Cubicle> cubicle;
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

		initActions();
	}

	/**
	 * Method who initialize swimmer action set
	 */
	private void initActions() {
		addAction(new TakeResourceAction<Basket>(this.basket, this.bp));
		addAction(new TakeResourceAction<Cubicle>(this.cubicle, this.cp));
		addAction(new ForeeasableAction("undressing", this.timeUndress));
		addAction(new FreeResourceAction<Cubicle>(this.cubicle, this.cp));
		addAction(new ForeeasableAction("swimming", this.timeSwam));
		addAction(new TakeResourceAction<Cubicle>(this.cubicle, this.cp));
		addAction(new ForeeasableAction("dressing", this.timeToDress));
		addAction(new FreeResourceAction<Cubicle>(this.cubicle, this.cp));
		addAction(new FreeResourceAction<Basket>(this.basket, this.bp));
	}
	/**
	 * Method who does the action : print turn of the swimmer and execute an action 
	 */
	public void doStep() {
		System.out.println(this.name + " play turn : ");
		super.doStep();
	}
}
