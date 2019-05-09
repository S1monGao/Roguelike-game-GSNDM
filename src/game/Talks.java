package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Player;

public class Talks extends Action{

	private Actor player;
	private Actor npc;	

	public Talks(Actor player, Actor npc) {
		this.player = player;
		this.npc = npc;
	}
	

	@Override
	public String execute(Actor actor, GameMap map) {
		if (!(actor instanceof Player))
			return null;
		for(Item item: actor.getInventory()) {
			if (item instanceof RocketPlan) {
				return npc + ": Hand them over, I don¡¯t have all day!\n";
			}
				
		}
		
		return npc + ": I can give you something that will help, but I¡¯m going to need the plans.\n";
		//return null;	
	}

	@Override
	public String menuDescription(Actor actor) {
		// TODO 
		return actor + " talks to " + this.npc;
	}

	@Override
	public String hotKey() {
		return "";
	}
	
}
