package pool;


public class SwimmerTest extends SchedulerTest {

	protected String name;
	protected BasketPool basketPool;
	protected CubiclePool cubiclePool;
	@Override
	public Action createAction() {
		name = "test";
		basketPool = new BasketPool(1);
		cubiclePool = new CubiclePool(1);
		Scheduler scheduler = new Swimmer(name,basketPool,cubiclePool,1,1,1);
		return scheduler;
		
	}



}
