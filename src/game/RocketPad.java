package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
public class RocketPad extends Ground{
	
	public RocketPad() {
		super('O');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions(new BuildRocketAction(location));
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}

	

}
