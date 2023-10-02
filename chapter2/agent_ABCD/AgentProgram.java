package chapter2.agent_AB;

import java.util.Random;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if (p.getLocationState() == Environment.LocationState.DIRTY){
			return Environment.SUCK_DIRT;
		}
		else{
			Random rand = new Random();
			int n = rand.nextInt(4);
			if (n == 0){
				return Environment.MOVE_LEFT;
			} else if (n == 1) {
				return Environment.MOVE_RIGHT;
			}
			 else if (n == 2) {
				return Environment.MOVE_UP;
			}
			 else if (n==3) {
				return Environment.MOVE_DOWN;
			}
		}
		return NoOpAction.NO_OP;

	}
}