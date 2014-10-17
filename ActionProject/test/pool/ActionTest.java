package pool;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class ActionTest {
	
	public abstract Action createAction();

	@Test(expected = ActionFinishedException.class)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedException{
		Action action = createAction();
		while(!action.isFinished()){
			try{
				action.doStep();
			} catch (ActionFinishedException e){
				fail("action was no supposed to be finshed, we just checked");
			}
		}
		
		assertTrue(action.isFinished());
		action.doStep(); // this should throw the ActionFinishedException
	}
}
