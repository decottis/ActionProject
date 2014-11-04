package pool;
/**
 * 
 * @author Escobedo Geoffrey && Wadin Jonathan
 *
 */
public class ForeeasableAction extends Action {

	protected String nameAction;

	public ForeeasableAction(String name, int numberOfStepsMax) {
		this.nameAction = name;
		this.nbStepsMax = numberOfStepsMax;
	}

	public void doStep() throws ActionFinishedException {
		super.doStep();
		if (++this.stepCounter == this.nbStepsMax) {
			this.state = State.FINISHED;
		} else {
			this.state = State.INPROGRESS;

		}
		System.out.println("\t" + this.nameAction + "(" + this.stepCounter
				+ "/" + this.nbStepsMax + ")");

	}
}
