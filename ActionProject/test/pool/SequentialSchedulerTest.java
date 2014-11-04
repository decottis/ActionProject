package pool;

public class SequentialSchedulerTest extends SchedulerTest {


	@Override
	public Action createAction() {
		Scheduler scheduler = new SequentialScheduler();
		scheduler.addAction(new ForeeasableAction("test", 2));
		return scheduler;
	}

}
