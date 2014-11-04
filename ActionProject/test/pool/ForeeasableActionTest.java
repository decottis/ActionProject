package pool;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ForeeasableActionTest extends ActionTest {

	protected int numberMax;

	@Before
	public void init() {
		this.numberMax = 20;
	}

	@Test
	public void isFinishedAfterTenInvocation() throws ActionFinishedException {
		numberMax = 10;
		ForeeasableAction foreeasableaction = new ForeeasableAction(
				"ForeesableAction", numberMax);
		for (int i = 0; i < numberMax; i++) {
			foreeasableaction.doStep();
			if (i < numberMax)
				assertFalse(foreeasableaction.isFinished());
			else
				assertTrue(foreeasableaction.isFinished());
		}
	}

	@Override
	public Action createAction() {
		return new ForeeasableAction("ForeesableAction", numberMax);
	}
}
