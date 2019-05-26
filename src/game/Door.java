package game;


import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import game.Opendoor;
// a door that can be open with a key

public class Door extends Ground {

	public Door() {
		super('+');
	}
	
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	
	@Override
	public Actions allowableActions(Actor actor, Location location, String direction){
		return new Actions(new Opendoor(direction, location));
	}
	
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
