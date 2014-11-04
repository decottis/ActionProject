package pool;


public class FairSchedulerTest extends SchedulerTest {

	@Override
	public Action createAction() {
		Scheduler scheduler = new FairScheduler();
		scheduler.addAction(new ForeeasableAction("test", 2));
		return scheduler;
	}

}
