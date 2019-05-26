package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class ProduceTank extends Action {
	//producing the water tank

@Override
	public  String execute(Actor actor, GameMap map){
		
		List<Item> itemlist = map.at(map.locationOf(actor).x(), map.locationOf(actor).y()).getItems();
		for(Item item:itemlist) {
			if(item.toString()=="tank") {
				return "There is a tank on your locations";
			}
		}
		if(((PlayerUpdated)actor).getBuildRound()==0) {
		((PlayerUpdated)actor).addBuildRound();
		}
		
		if(((PlayerUpdated)actor).getBuildRound()==1) {
			return "Player is building the tank";
		}
			
		return "Player start building the tank";
		
		
			
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
