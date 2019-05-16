package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class ProduceTank extends Action {
	

@Override
	public  String execute(Actor actor, GameMap map){
		
		List<Item> itemlist = map.at(map.locationOf(actor).x(), map.locationOf(actor).y()).getItems();
		for(Item item:itemlist) {
			if(item.toString()=="tank") {
				return "There is a tank on your locations";
			}
		}
		((PlayerUpdated)actor).addBuildRound();
		return "producing success";
		
		
			
	}
	

@Override
	public String menuDescription(Actor actor){

		return actor + " produce oxygen tank";
	}
	
@Override
	public String hotKey() {
	return "";
	
}

}
