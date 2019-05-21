package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

public class PoolOfWater extends Ground{

	public PoolOfWater() {
		super('~');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}

	public boolean blocksThrownObjects() {
		return true;
	}
	
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions(new FillWaterAction());
	}
	
}
