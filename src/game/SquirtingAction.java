package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class SquirtingAction extends Action{
	//Squiring water on the final boss makes it venerable to damage
	private Actor subject;
	private Actor actor;
	
	public SquirtingAction(Actor actor,Actor subject) {
		this.subject = subject;
		this.actor = actor;
	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		// TODO Auto-generated method stub
		boolean found = false;
		WaterGun gun = null;
		for(Item item: actor.getInventory()) {
			if (item.toString() == "watergun") {
				found = true;
				gun = (WaterGun) item;
			}
		}
		
		if(!found) {
			return "watergun not found";
		}
		
		else if(Math.random()<=0.7 && gun.isFilled()) {
			((YugoMaxx)subject).breakExoskeleton();
			gun.shoot();
			return "the water gun hit " + subject;
		}
		
		else if(gun.isFilled()){
			gun.shoot();
			return "the water gun dosen't hit " + subject;
		}
		
		else {
			return "no water in the gun! the action has no effect";
		}
		
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO Auto-generated method stub
		return this.actor + " Squirting water on " + subject;
	}

	@Override
	public String hotKey() {
		// TODO Auto-generated method stub
		return "";
	}
	

}
