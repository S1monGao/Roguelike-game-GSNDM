package game;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.Player;
import edu.monash.fit2099.engine.Item;

public class BuildRocketAction extends Action{
	
	private Location rocketLocation;
	
	public  BuildRocketAction(Location rocketLocation) {
		this.rocketLocation = rocketLocation;

	}

	@Override
	public String execute(Actor actor, GameMap map) {
		int counter=0;
		 List<Item> itemlist = map.at(22, 10).getItems();
		 for(Item item:itemlist) {
			 if(item.toString()=="rocketengine") {
				 counter+=1;
			 }
			 if(item.toString()=="rocketbody") {
				 counter+=2;
			 }
		 }
		if(counter==3) {
			Item rocket = new Item("Rocket", 'R');
			map.add(new Floor(), rocketLocation);
			map.addItem(rocket, 22, 10);
			return "building successful,you win the game";
			
		}
		else if(counter==1) {
			return "You do not drop rocketbody on the pad";
		 }
		else if(counter==2) {
			 return "You do not drop rocketengine on the pad";
		 }		 
		return "You do not have both rocketbody and rocketengine";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " Put body and engine on the pad and build the rocket ";
	}

	@Override
	public String hotKey() {
		// TODO Auto-generated method stub
		return "";
	}
	
	
	

}
