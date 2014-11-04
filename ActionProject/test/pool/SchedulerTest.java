package pool;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class SchedulerTest extends ActionTest {

	@Override
	public abstract Action createAction();

	public abstract Scheduler createScheduler();

	@Test(expected = ActionFinishedException.class)
	public void doStepWhileFinishedThrowsException()
			throws ActionFinishedException {
		Scheduler scheduler = createScheduler();
		while (!scheduler.isFinished()) {
			try {
				scheduler.doStep();
			} catch (ActionFinishedException e) {
				fail("scheduler was no supposed to be finished, we just checked");
			}
		}

		assertTrue(scheduler.isFinished());
		scheduler.doStep(); // this should throw the ActionFinishedException
	}
}
