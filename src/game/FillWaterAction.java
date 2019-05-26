package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class FillWaterAction extends Action{
	//fill up the water in water gun
	@Override
	public String execute(Actor actor, GameMap map) {
		for(Item item: actor.getInventory()) {
			if (item instanceof WaterGun) {
				((WaterGun) item).fill();
				return "Player filled water";
			}
		}
		
		return "You don't have the water gun";
			
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " fills the Watergun";
	}

	@Override
	public String hotKey() {
		return "";
	}


}
