package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class CosumeTank extends Action{
	//consume the tank and restore oxygen point
	@Override
	public  String execute(Actor actor, GameMap map){
		
		List<Item> itemlist = map.at(map.locationOf(actor).x(), map.locationOf(actor).y()).getItems();
		for(int i =0;i<itemlist.size();i++) {
			if(itemlist.get(i).toString()=="tank")
			{
				map.locationOf(actor).removeItem(itemlist.get(i));
				((PlayerUpdated) actor).addoxygen();
				return "Your oxygen point refilled.";
			}
		}

			return "No Oxygen tank found in this location.";
			
	}
	

@Override
	public String menuDescription(Actor actor){

		return actor + " cosume the tank";
	}
	
@Override
	public String hotKey() {
	return "";
	
}


}
