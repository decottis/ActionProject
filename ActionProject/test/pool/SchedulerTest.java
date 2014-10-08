package pool;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class SchedulerTest extends ActionTest{

	@Override
	public abstract Action createAction();
	
	public abstract Scheduler createScheduler();

	@Test(expected = ActionFinishedExeption.class)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedExeption{
		Scheduler scheduler = createScheduler();
		while(!scheduler.isFinished()){
			try{
				scheduler.doStep();
			} catch (ActionFinishedExeption e){
				fail("scheduler was no supposed to be finished, we just checked");
			}
		}
		
		assertTrue(scheduler.isFinished());
		scheduler.doStep(); //this should throw the ActionFinishedException
	}
}
