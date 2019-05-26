package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Player;

public class ExchangePlan extends Action{
	//exchange rocket plan with NPC
		private Actor npc;	

		/**
		 * @param player
		 * @param npc
		 */
		public ExchangePlan(Actor player, Actor npc) {
			this.npc = npc;
		}
		

		@Override
		public String execute(Actor actor, GameMap map) {
			if (!(actor instanceof Player))
				return actor + " try to Exchange with " + npc +" !";
			
			for(Item item: actor.getInventory()) {
				if (item instanceof RocketPlan) {
				actor.removeItemFromInventory(item);
				RocketBody rocketbody = new RocketBody();
				map.locationOf(npc).addItem(rocketbody);
				map.removeActor(npc);
				return "Plan Exchanged! And Q disappeared.\n";
				}
			}
				
			return "You dont have the plan!\n";
			
		}

		@Override
		public String menuDescription(Actor actor) {
			// TODO 
			return actor + " exchange plan with " + this.npc;
		}

		@Override
		public String hotKey() {
			return "";
		}
		
}



