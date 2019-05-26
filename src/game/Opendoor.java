package game;
import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Item;

public class Opendoor extends Action {
	//action used when opening a door
	private Location doorLocation;
	private String direction;
	
	/**
	 * @param direction
	 * @param doorLocation
	 */
	public  Opendoor(String direction,Location doorLocation) {
		this.direction = direction;
		this.doorLocation = doorLocation;

	}
	
	@Override
	public String execute(Actor actor, GameMap map) {
		
		for(Item item: actor.getInventory()) {
			if(item.toString() == "key") {
				map.add(new Floor(), doorLocation);
				return "The door is opened";
			}
		}
		
		
				return actor + " need a key to open the door";
		}
	

	@Override
	public String menuDescription(Actor actor) {
		return actor + " open the door to the "+this.direction;
	}

	@Override
	public String hotKey() {
		return "";
	}

}
