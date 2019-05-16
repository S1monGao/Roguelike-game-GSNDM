package game;

import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;

public class CosumeTank extends Action{
	
	@Override
	public  String execute(Actor actor, GameMap map){
		((PlayerUpdated) actor).addoxygen();
		List<Item> itemlist = map.at(map.locationOf(actor).x(), map.locationOf(actor).y()).getItems();
		for(int i =0;i<itemlist.size();i++) {
			if(itemlist.get(i).toString()=="tank")
			{
				map.locationOf(actor).removeItem(itemlist.get(i));
			}
		}
		return "Your oxygen point added 10";

			
			
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
