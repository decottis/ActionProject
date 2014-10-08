package pool;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class ActionTest {
	
	public abstract Action createAction();

	@Test(expected = ActionFinishedExeption.class)
	public void doStepWhileFinishedThrowsException() throws ActionFinishedExeption{
		Action action = createAction();
		while(!action.isFinished()){
			try{
				action.doStep();
			} catch (ActionFinishedExeption e){
				fail("action was no supposed to be finshed, we just checked");
			}
		}
		
		assertTrue(action.isFinished());
		action.doStep(); //this should throw the ActionFinishedException
	}
}
