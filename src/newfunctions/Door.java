package newfunctions;


import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;


public class Door extends Ground {

	public Door() {
		super('+');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
