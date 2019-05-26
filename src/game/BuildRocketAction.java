package game;
import java.util.List;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.MoveActorAction;
import edu.monash.fit2099.engine.Item;

//Action for building the rocket
public class BuildRocketAction extends Action{
	private GameMap moon;
	
	
	/**
	 * @param moon
	 */
	public  BuildRocketAction(GameMap moon) {
		this.moon = moon;

	}
/*To check the rocketengine and body on the pad or not.And return the right hint to player
 * 
 */
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
			Item rocket = Item.newFurniture("Rocket", '^');
			rocket.getAllowableActions().add(new MoveActorAction(moon.at(7, 2), "to Moon!"));
			map.addItem(rocket, 22, 10);
			return "Rocket building successful!";
		}
		else if(counter==1) {
			return "You do not drop rocketbody on the pad";
		 }
		else if(counter==2) {
			 return "You do not drop rocketengine on the pad";
		 }		 
		return "You do not drop both rocketbody and rocketengine on pad";
	}

	@Override
	public String menuDescription(Actor actor) {
		return actor + " build the rocket ";
	}

	@Override
	public String hotKey() {
		// TODO Auto-generated method stub
		return "";
	}
	
	
	

}
