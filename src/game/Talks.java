package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.GameMap;

public class Talks extends Action{

	private Actor player;
	private Actor npc;	

	public Talks(Actor player, Actor npc) {
		this.player = player;
		this.npc = npc;
	}
	

	@Override
	public String execute(Actor actor, GameMap map) {
		RocketPlan RocketPlan = new RocketPlan();
		if (actor.getInventory().contains(RocketPlan)) {
			return "傻逼范司机快点把东西给我";
		}
		else {
			return "傻逼范司机快点去找东西给我";
		}
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
