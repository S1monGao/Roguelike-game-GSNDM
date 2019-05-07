package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ExchangePlan extends Action{

		private Actor npc;	

		public ExchangePlan(Actor player, Actor npc) {
			this.npc = npc;
		}
		

		@Override
		public String execute(Actor actor, GameMap map) {
			RocketPlan RocketPlan = new RocketPlan();
			if (actor.getInventory().contains(RocketPlan)) {
				actor.removeItemFromInventory(RocketPlan);
				actor.addItemToInventory(new RocketEngine());
				return "\nPlan Exchanged !\n";
			}
			else {
				return "\nYou dont have the plan!\n";
			}
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



